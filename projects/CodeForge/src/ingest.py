from __future__ import annotations
from typing import List, Dict, Any, Optional, Iterable
from pathlib import Path
import xml.etree.ElementTree as ET

# --- utilidades --------------------------------------------------------------

def strip_ns(tag: str) -> str:
    # "{namespace}tag" -> "tag"
    if not isinstance(tag, str):
        return tag
    return tag.split('}', 1)[-1] if tag.startswith('{') else tag

def tag_eq(elem: ET.Element, names: Iterable[str]) -> bool:
    t = strip_ns(elem.tag).lower()
    return t in {n.lower() for n in names}

def text_of(n: Optional[ET.Element]) -> str:
    if n is None:
        return ""
    # get all text including nested tails
    txt = (n.text or "")
    for child in n:
        txt += (child.text or "") + (child.tail or "")
    return " ".join(txt.split()).strip()

def is_true(v: Optional[str]) -> bool:
    if not v:
        return False
    v = v.strip().lower()
    return v in {"true", "yes", "y", "1", "si", "sí", "correct", "correcto"}

# --- parseo ------------------------------------------------------------------

QUESTION_TAGS = {"question", "pregunta", "item"}
TEXT_TAGS     = {"text", "enunciado", "statement", "titulo", "title"}
OPTION_TAGS   = {"option", "answer", "respuesta", "alternativa", "opcion"}
CORR_TAGS     = {"correct", "is_correct", "right", "ok"}

def find_questions(root: ET.Element) -> List[ET.Element]:
    out = []
    for n in root.iter():
        if isinstance(n.tag, str) and strip_ns(n.tag).lower() in QUESTION_TAGS:
            out.append(n)
    return out

def find_first_any(node: ET.Element, names: Iterable[str]) -> Optional[ET.Element]:
    names_l = {n.lower() for n in names}
    for child in node.iter():
        if isinstance(child.tag, str) and strip_ns(child.tag).lower() in names_l:
            return child
    return None

def find_children_any(node: ET.Element, names: Iterable[str]) -> List[ET.Element]:
    names_l = {n.lower() for n in names}
    out = []
    for child in node:
        if isinstance(child.tag, str) and strip_ns(child.tag).lower() in names_l:
            out.append(child)
    return out

def option_is_correct(on: ET.Element) -> bool:
    # Por atributos comunes
    for att in ["correct", "is_correct", "right", "ok", "value"]:
        if att in on.attrib:
            v = on.attrib.get(att, "")
            # value="correct" lo tratamos como True
            if att == "value":
                if v.strip().lower() == "correct":
                    return True
            elif is_true(v):
                return True
    # Por etiqueta hija <correct>true</correct> o <is_correct>true</is_correct>
    child = find_first_any(on, CORR_TAGS)
    if child is not None and is_true(text_of(child) or "true"):
        return True
    return False

def parse_xml_questions(xml_path: Path) -> List[Dict[str, Any]]:
    tree = ET.parse(xml_path)
    root = tree.getroot()

    q_nodes = find_questions(root)
    parsed: List[Dict[str, Any]] = []

    for qn in q_nodes:
        # texto de la pregunta
        text_node = find_first_any(qn, TEXT_TAGS)
        q_text = text_of(text_node) or (qn.attrib.get("text", "")).strip() or text_of(qn)
        q_text = " ".join(q_text.split())
        if not q_text:
            continue

        # opciones
        option_nodes = find_children_any(qn, OPTION_TAGS)
        options = []
        correct_indices = []
        for idx, on in enumerate(option_nodes):
            o_text = text_of(on) or (on.attrib.get("text", "")).strip()
            o_text = " ".join(o_text.split())
            options.append({"text": o_text})
            if option_is_correct(on):
                correct_indices.append(idx)

        # Reglas: al menos 2 opciones y exactamente 1 correcta
        if len(options) >= 2 and len(correct_indices) == 1:
            parsed.append({
                "text": q_text,
                "options": options,
                "correct_index": correct_indices[0],
                "source": str(xml_path.name)
            })

    return parsed
