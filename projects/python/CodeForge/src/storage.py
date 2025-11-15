from __future__ import annotations
import json
from pathlib import Path
from typing import Dict, Any, List

DB_PATH = Path(__file__).resolve().parents[1] / "data" / "questions.json"

def ensure_db() -> None:
    DB_PATH.parent.mkdir(parents=True, exist_ok=True)
    if not DB_PATH.exists():
        DB_PATH.write_text(json.dumps({"questions": []}, ensure_ascii=False, indent=2), encoding="utf-8")

def load_db() -> Dict[str, Any]:
    ensure_db()
    with DB_PATH.open("r", encoding="utf-8") as f:
        return json.load(f)

def save_db(db: Dict[str, Any]) -> None:
    DB_PATH.parent.mkdir(parents=True, exist_ok=True)
    with DB_PATH.open("w", encoding="utf-8") as f:
        json.dump(db, f, ensure_ascii=False, indent=2)

def add_questions(new_questions: List[Dict[str, Any]]) -> int:
    """Añade preguntas evitando duplicados por (text + opciones)."""
    db = load_db()
    existing = {(q["text"].strip(), tuple(o["text"].strip() for o in q["options"])) for q in db["questions"]}
    added = 0
    for q in new_questions:
        key = (q["text"].strip(), tuple(o["text"].strip() for o in q["options"]))
        if key not in existing:
            db["questions"].append(q)
            existing.add(key)
            added += 1
    save_db(db)
    return added

def get_all_questions() -> List[Dict[str, Any]]:
    return load_db().get("questions", [])
