from __future__ import annotations
from typing import List, Dict, Any, Optional
from pathlib import Path
import xml.etree.ElementTree as ET

def _text(n: Optional[ET.Element]) -> str:
    return (n.text or "").strip() if n is not None else ""

def _is_true(value: str) -> bool:
    return value.strip().lower() in {"true", "yes", "y", "1", "si", "sí", "correct", "correcto"}

def _find_children_any(node: ET.Element, names: List[str]) -> List[ET.Element]:
    out = []
    for child in node:
        if child.tag.lower() in names:
            out.append(child)
    return out

def _find_first_any(node: ET.Element, names: List[str]) -> Optional[ET.Element]:
    for child in node.iter():
        if isinstance(child.tag, str) and child.tag.lower() in names:
            return child
    return None

def parse_xml_questions(xml_path: Path) -> List[Dict[str, Any]]:
    """
    Parser tolerante a esquemas comunes:
    - <question> / <pregunta> con opciones <option|answer|respuesta>
      Marcado de la correcta por:
        * atributo correct="true|yes|1|si|sí"
        * atributo value="correct"
        * atributo is_correct="true"
        * etiqueta <correct>true</correct> dentro de la opción
    Se ignoran preguntas sin exactamente 1 correcta.
    """
    tree = ET.parse(xml_path)
    root = tree.getroot()

    questions_nodes = [n for n in root.iter() if isinstance(n.tag, str) and n.tag.lower() in {"question", "pregunta"}]
    if not questions_nodes:
        # fallback: por si el XML es <test><item>...
        questions_nodes = [n for n in root.iter() if isinstance(n.tag, str) and n.tag.lower() in {"item"}]

    parsed: List[Dict[str, Any]] = []
    for qn in questions_nodes:
        # texto de la pregunta
        text_node = _find_first_any(qn, ["text", "enunciado", "statement", "titulo", "title"])
        q_text = _text(text_node) or (qn.attrib.get("text", "")).strip() or _text(qn)
        q_text = " ".join(q_text.split())
        if not q_text:
            continue

        # opciones
        option_nodes = _find_children_any(qn, ["option", "answer", "respuesta", "alternativa"])
        options = []
        correct_indices = []
        for idx, on in enumerate(option_nodes):
            o_text = _text(on) or (on.attrib.get("text", "")).strip()
            o_text = " ".join(o_text.split())

            # heurísticas de "correcto"
            is_corr = False
            for att in ["correct", "is_correct", "right", "ok", "value"]:
                v = on.attrib.get(att)
                if v and _is_true(v if att != "value" else (v == "correct")):
                    is_corr = True
                    break
            if not is_corr:
                corr_tag = _find_first_any(on, ["correct", "is_correct"])
                if corr_tag is not None and _is_true(_text(corr_tag) or "true"):
                    is_corr = True

            options.append({"text": o_text})
            if is_corr:
                correct_indices.append(idx)

        # Solo aceptamos preguntas con >=2 opciones y exactamente 1 correcta
        if len(options) >= 2 and len(correct_indices) == 1:
            parsed.append({
                "text": q_text,
                "options": options,
                "correct_index": correct_indices[0],
                "source": str(xml_path.name)
            })

    return parsed
