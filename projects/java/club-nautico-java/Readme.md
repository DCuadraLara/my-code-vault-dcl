# 🚤 Club Náutico -- Boat Management System (Java -- DAM)

This project was developed as a practical assignment for Units 1, 2 and
3 of the **Programming** module in the DAM program.\
The goal is to manage different types of boats using **OOP**, **control
structures**, **data validation**, and **modular design**.

------------------------------------------------------------------------

## 📌 Main Features

The program allows you to:

-   Register different types of boats:
    -   Sailboat\
    -   Yacht\
    -   Fishing boat\
    -   Sport boat\
-   Display all registered boats\
-   Edit the data of an existing boat\
-   Delete boats\
-   Search boats by ID\
-   Calculate base fees and apply discounts (WIP)

All data is stored in memory using an `ArrayList`.

------------------------------------------------------------------------

## 🧱 Project Structure

    club-nautico-java/
    │
    ├── README.md
    └── src/
        └── clubnautico/
            ├── ClubNautico.java
            ├── Embarcacion.java
            ├── Velero.java
            ├── Yate.java
            ├── Pesquera.java
            ├── Deportiva.java
            └── InputUtils.java

------------------------------------------------------------------------

## 🧩 Technologies & Concepts Used

-   **Java 17+**
-   Standard input with `Scanner`
-   Object-Oriented Programming:
    -   Classes & objects\
    -   Inheritance\
    -   Polymorphism\
    -   Enums\
    -   `instanceof`\
-   Static utility methods\
-   Input validation\
-   Date handling with `LocalDate`

------------------------------------------------------------------------

## 🔧 Key Classes

### ✔ `Embarcacion` (Base Class)

Contains shared attributes: - Automatic ID\
- Name\
- Length (eslora)\
- Registration date\
- Type (enum)\
- Member / non-member status\
- Methods for calculating base fees and discounts

------------------------------------------------------------------------

### ✔ Specific Subclasses

Each boat type includes its own additional fields:

-   `Velero` → masts, crew size, captain, size category\
-   `Yate` → power, cabins, size category\
-   `Pesquera` → capacity, license, fishing zone, size category\
-   `Deportiva` → power, competition flag, model, size category

------------------------------------------------------------------------

### ✔ `InputUtils`

Utility class for validated input: - Non-empty strings\
- Positive integers\
- Positive doubles\
- Boolean YES/NO input

------------------------------------------------------------------------

## ▶️ Running the Program

Compile:

``` bash
javac src/clubnautico/*.java
```

------------------------------------------------------------------------

## 🛠 Planned Improvements (v1.1 -- v2.0)

-   Add a submenu to modify type-specific fields\
-   Show detailed information when listing boats\
-   File persistence (JSON / CSV)\
-   More advanced fee calculation\
-   Search by name\
-   Optional refactor to MVC architecture

------------------------------------------------------------------------

## 👨‍💻 Author

**David Cuadra Lara**\
Academic project -- DAM (2025)
