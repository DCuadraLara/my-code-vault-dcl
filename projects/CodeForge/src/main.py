from __future__ import annotations
import argparse
from pathlib import Path
from typing import List
from src.storage import ensure_db, get_all_questions, add_questions
from src.ingest import parse_xml_questions
from src.quiz import run_quiz
from src.report import write_report


def cmd_ingest(files: List[str]) -> None:
    ensure_db()
    total_added = 0
    for f in files:
        p = Path(f)
        if not p.exists():
            print(f"⛔ No se encuentra: {p}")
            continue
        try:
            parsed = parse_xml_questions(p)
            added = add_questions(parsed)
            print(f"✅ {p.name}: {added} preguntas añadidas (de {len(parsed)} válidas detectadas).")
            total_added += added
        except Exception as e:
            print(f"⛔ Error procesando {p.name}: {e}")
    print(f"\nTotal añadidas al JSON: {total_added}")

def cmd_quiz(n: int) -> None:
    qs = get_all_questions()
    if not qs:
        print("⛔ Base de datos vacía. Ingresa algún XML primero con `python -m src.main ingest tests/*.xml`")
        return
    n = min(n, len(qs))
    print(f"Iniciando examen con {n} preguntas (de {len(qs)} disponibles). ¡Suerte!")
    result = run_quiz(qs, n)
    rep_path = write_report(result)
    print(f"\n📄 Reporte generado: {rep_path}")

def main():
    parser = argparse.ArgumentParser(description="CodeForge — Test bot CLI")
    sub = parser.add_subparsers(dest="cmd", required=True)

    p_ing = sub.add_parser("ingest", help="Ingesta de tests XML")
    p_ing.add_argument("files", nargs="+", help="Rutas a archivos XML")

    p_quiz = sub.add_parser("quiz", help="Realiza un examen aleatorio")
    p_quiz.add_argument("-n", "--num", type=int, default=10, help="Número de preguntas (por defecto 10)")

    args = parser.parse_args()
    if args.cmd == "ingest":
        cmd_ingest(args.files)
    elif args.cmd == "quiz":
        cmd_quiz(args.num)

if __name__ == "__main__":
    main()
