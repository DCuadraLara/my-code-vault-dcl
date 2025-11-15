from __future__ import annotations
import random
from typing import List, Dict, Any

def run_quiz(questions: List[Dict[str, Any]], n: int) -> Dict[str, Any]:
    if not questions:
        raise ValueError("No hay preguntas en la base de datos.")
    pool = random.sample(questions, min(n, len(questions)))

    correct = 0
    mistakes = []

    for i, q in enumerate(pool, start=1):
        print(f"\n[{i}/{len(pool)}] {q['text']}")
        # barajar opciones conservando índice
        indices = list(range(len(q["options"])))
        random.shuffle(indices)
        shuffled = [q["options"][k] for k in indices]

        # determinar índice(s) correctos en el arreglo barajado
        if q.get("multi"):
            correct_orig = set(q["correct_indices"])
            correct_new = {indices.index(k) for k in correct_orig}
        else:
            correct_new = {indices.index(q["correct_index"])}

        # mostrar
        for j, opt in enumerate(shuffled, start=1):
            print(f"  {j}. {opt['text']}")

        # entrada usuario
        if q.get("multi"):
            prompt = "Tu respuesta (varias separadas por comas, ej. 1,3): "
            while True:
                raw = input(prompt).strip()
                try:
                    chosen = {int(x)-1 for x in raw.replace(" ", "").split(",") if x}
                except ValueError:
                    print("⛔ Formato inválido. Ejemplo válido: 1,3")
                    continue
                if chosen and all(0 <= x < len(shuffled) for x in chosen):
                    break
                print("⛔ Números fuera de rango.")
        else:
            prompt = "Tu respuesta (número): "
            while True:
                raw = input(prompt).strip()
                if raw.isdigit() and 1 <= int(raw) <= len(shuffled):
                    chosen = {int(raw)-1}
                    break
                print("⛔ Escribe un número válido.")

        # corrección
        if chosen == correct_new:
            print("✅ ¡Correcto!")
            correct += 1
        else:
            print("❌ Incorrecto.")
            your_ans_text = ", ".join(shuffled[x]["text"] for x in sorted(chosen))
            corr_text = ", ".join(shuffled[x]["text"] for x in sorted(correct_new))
            mistakes.append({
                "question": q["text"],
                "your_answer": your_ans_text,
                "correct_answer": corr_text
            })

    score = round(100 * correct / len(pool), 2)
    return {"total": len(pool), "correct": correct, "score": score, "mistakes": mistakes}
