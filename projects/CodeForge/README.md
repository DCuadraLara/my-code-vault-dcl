# CodeForge
*A personal lab for forging programming skills through automation, testing, and experimentation.*

---

## 🧩 Overview
**CodeForge** is a lightweight framework designed to:
- **Ingest** programming quizzes or test banks in **XML format**  
- **Validate** and **filter out** incorrect or incomplete questions  
- **Persist** the correct data into a local **JSON database**  
- Provide an **Exam Mode** that allows self-testing with real feedback  

The goal is to help you *learn smarter* — by building your own adaptive study system powered by automation and clean data handling.

---

## 🧠 Core Features
| Feature | Description |
|----------|--------------|
| 🗂️ XML Import | Reads raw tests from `/data/incoming/` |
| 🧮 Validation | Checks structure, unique IDs, valid answers, etc. |
| 🧹 Filtering | Discards incorrect or duplicate questions |
| 💾 JSON Database | Stores verified questions for reuse |
| 🧪 Exam Mode | Presents random questions and evaluates answers |
| 📊 Stats | (Planned) Track progress, topics, and success rates |

---

## 🧰 Data Flow
1. **Import** XML → validate → discard bad entries  
2. **Persist** valid questions → JSON DB (`data/db/questions.json`)  
3. **Exam Mode** → pull questions → interactive answers → feedback  
4. (Optionally) log rejected entries to `data/rejected/`

---

## 🧾 Example XML Input
```xml
<test day="2" topic="python-basics">
  <question id="q-0001" difficulty="easy">
    <prompt>What does .strip() do?</prompt>
    <choice key="A">Removes surrounding whitespace</choice>
    <choice key="B">Converts to lowercase</choice>
    <choice key="C">Splits a string by spaces</choice>
    <answer>A</answer>
    <explanation>strip() trims leading/trailing whitespace.</explanation>
  </question>
</test>
