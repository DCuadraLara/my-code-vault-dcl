from __future__ import annotations
from typing import List, Dict, Any, Optional, Iterable
from pathlib import Path
import xml.etree.ElementTree as ET

def _strip_ns(tag: str) -> str:
    return tag.split('}', 1)[-1] if isinstance(tag, str) and tag.startswith('{') else tag

def _text(n: Optional[ET.Element]) -> str:
    if n is None:
        return ""
    txt = (n.text or "")
    for c in n:
        txt += (c.text or "") + (c.tail or "")
    return " ".join(txt.split()).strip()

def _is_true(v: Optional[str]) -> bool:
    if not v:
        return False
    return v.strip().lower() in {"true", "yes", "y", "1", "si", "sí", "correct", "correcto", "verdadero", "ok"}

def parse_xml_questions(xml_path: Path) -> List[Dict[str, Any]]:
    """
    Parser adaptado a tu esquema:
    - <pregunta> con <enunciado> y <opciones> [multiple="true"|...]
    - <opcion correcta="true"> marca las correctas
    - Si no hay ninguna correcta -> se descarta
    - Si multiple="true": admite varias correctas
      Si NO multiple: exige exactamente 1 correcta
    Además:
    - Ignora preguntas sin texto o con < 2 opciones
    """
    tree = ET.parse(xml_path)
    root = tree.getroot()

    parsed: List[Dict[str, Any]] = []
    for qn in root.iter():
        if not isinstance(qn.tag, str):
            continue
        if _strip_ns(qn.tag).lower() != "pregunta":
            continue

        # enunciado
        enunciado_node = None
        for ch in qn:
            if isinstance(ch.tag, str) and _strip_ns(ch.tag).lower() == "enunciado":
                enunciado_node = ch
                break
        q_text = _text(enunciado_node) or _text(qn)
        if not q_text:
            continue

        # opciones
        opciones_node = None
        for ch in qn:
            if isinstance(ch.tag, str) and _strip_ns(ch.tag).lower() == "opciones":
                opciones_node = ch
                break
        if opciones_node is None:
            continue

        is_multi = _is_true(opciones_node.attrib.get("multiple", ""))

        options = []
        correct_idx: List[int] = []
        for i, on in enumerate(list(opciones_node)):
            if not isinstance(on.tag, str) or _strip_ns(on.tag).lower() != "opcion":
                continue
            o_text = _text(on) or on.attrib.get("valor", "").strip()
            options.append({"text": o_text})
            if _is_true(on.attrib.get("correcta")) or _is_true(on.attrib.get("correct")) or _is_true(on.attrib.get("is_correct")):
                correct_idx.append(i)

        # reglas mínimas
        if len(options) < 2:
            continue
        if is_multi:
            if len(correct_idx) < 1:
                # multi sin ninguna correcta -> no hay clave de corrección
                continue
            qobj = {
                "text": q_text,
                "options": options,
                "correct_indices": correct_idx,
                "multi": True,
                "source": xml_path.name
            }
            parsed.append(qobj)
        else:
            if len(correct_idx) != 1:
                # de una sola respuesta pero sin exactamente 1 correcta -> descartamos
                continue
            qobj = {
                "text": q_text,
                "options": options,
                "correct_index": correct_idx[0],
                "multi": False,
                "source": xml_path.name
            }
            parsed.append(qobj)

    return parsed
