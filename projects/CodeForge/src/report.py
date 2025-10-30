from __future__ import annotations
from pathlib import Path
from datetime import datetime
from typing import Dict, Any, List

REPORTS_DIR = Path(__file__).resolve().parents[1] / "reports"
REPORTS_DIR.mkdir(parents=True, exist_ok=True)

TIPS_BASE = [
    "- Relee bien todas las opciones antes de responder.",
    "- Identifica palabras clave en el enunciado (siempre, nunca, excepto...).",
    "- Si dudas entre dos, elimina primero las claramente falsas.",
]

def _build_tips(mistakes: List[Dict[str, Any]]) -> List[str]:
    tips = TIPS_BASE[:]
    if mistakes:
        tips.append("- Repasa específicamente los conceptos fallados (ver lista abajo).")
    return tips

def write_report(result: Dict[str, Any]) -> Path:
    now = datetime.now().strftime("%Y%m%d_%H%M%S")
    path = REPORTS_DIR / f"report_{now}.txt"

    lines = []
    lines.append("=== CodeForge Exam Report ===")
    lines.append(f"Fecha: {datetime.now().isoformat(timespec='seconds')}")
    lines.append("")
    lines.append(f"Total preguntas: {result['total']}")
    lines.append(f"Respuestas correctas: {result['correct']}")
    lines.append(f"Nota: {result['score']} / 100")
    lines.append("")
    if result["mistakes"]:
        lines.append("Preguntas falladas:")
        for m in result["mistakes"]:
            lines.append(f"- {m['question']}")
            lines.append(f"  Tu respuesta: {m['your_answer']}")
            lines.append(f"  Correcta: {m['correct_answer']}")
        lines.append("")

    lines.append("Tips:")
    for t in _build_tips(result["mistakes"]):
        lines.append(f"  {t}")

    path.write_text("\n".join(lines), encoding="utf-8")
    return path
