from __future__ import annotations
import random
from typing import List, Dict, Any

def run_quiz(questions: List[Dict[str, Any]], n: int) -> Dict[str, Any]:
    if not questions:
        raise ValueError("No hay preguntas en la base de datos. Ingresa tests XML primero.")
    pool = questions[:] if len(questions) <= n else random.sample(questions, n)

    correct = 0
    mistakes = []
    for i, q in enumerate(pool, start=1):
        print(f"\n[{i}/{len(pool)}] {q['text']}")
        options = q["options"][:]
        # barajamos pero recordamos dónde quedó la correcta
        indices = list(range(len(options)))
        random.shuffle(indices)
        inv = {new_i: old_i for new_i, old_i in enumerate(indices)}
        shuffled = [options[idx] for idx in indices]
        correct_new_index = indices.index(q["correct_index"])

        for j, opt in enumerate(shuffled, start=1):
            print(f"  {j}. {opt['text']}")
        while True:
            raw = input("Tu respuesta (número): ").strip()
            if raw.isdigit() and 1 <= int(raw) <= len(shuffled):
                ans = int(raw) - 1
                break
            print("⛔ Entrada inválida. Escribe un número válido.")

        if ans == correct_new_index:
            print("✅ ¡Correcto!")
            correct += 1
        else:
            print("❌ Incorrecto.")
            mistakes.append({
                "question": q["text"],
                "your_answer": shuffled[ans]["text"],
                "correct_answer": shuffled[correct_new_index]["text"]
            })

    score = round(100 * correct / len(pool), 2)
    return {
        "total": len(pool),
        "correct": correct,
        "score": score,
        "mistakes": mistakes
    }
