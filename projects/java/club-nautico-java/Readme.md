# 🚤 Club Náutico – Gestión de Embarcaciones (Java – DAM)

Proyecto desarrollado como práctica de los Temas 1, 2 y 3 del módulo de **Programación (DAM)**.  
El objetivo es gestionar embarcaciones de distintos tipos aplicando **POO**, **estructuras de control**, **validación de datos** y **modularidad**.

---

## 📌 Funcionalidad principal

El programa permite:

- Registrar embarcaciones de distintos tipos  
  - Velero  
  - Yate  
  - Pesquera  
  - Deportiva  
- Mostrar listado de embarcaciones almacenadas  
- Modificar datos de una embarcación existente  
- Eliminar embarcaciones  
- Buscar embarcaciones por ID  
- Calcular tarifas base y aplicar descuentos (WIP)

Todos los datos se almacenan en memoria mediante un `ArrayList`.

---

## 🧱 Estructura del proyecto

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


---

## 🧩 Tecnologías utilizadas

- **Java 17+**
- Entrada estándar con `Scanner`
- Uso de:
  - POO  
  - Herencia  
  - Enumeraciones  
  - `instanceof`  
  - Métodos estáticos  
  - Validación de entrada  
  - Manejo de fechas con `LocalDate`

---

## 🔧 Clases principales

### ✔ `Embarcacion`
Clase base con atributos comunes:
- ID automático
- Nombre  
- Eslora  
- Fecha de registro  
- Tipo (enum)  
- Socio / no socio  
- Métodos de tarifa y descuento

### ✔ Subclases específicas
Cada embarcación añade sus propios atributos:

- `Velero` → mástiles, tripulación, capitán, tamaño  
- `Yate` → potencia, camarotes, tamaño  
- `Pesquera` → capacidad, licencia, zona, tamaño  
- `Deportiva` → potencia, competición, modelo, tamaño  

### ✔ `InputUtils`
Clase de utilidades para lectura validada:
- Strings no vacíos  
- Enteros positivos  
- Doubles positivos  
- Booleanos SI/NO  

---

## ▶️ Ejecución

Compilar:

```bash
javac src/clubnautico/*.java

---

### 🛠 Próximas mejoras (v1.1 – v2.0)

Añadir submenú para modificar datos específicos por tipo

Mostrar información específica al listar embarcaciones

Persistencia en archivo (JSON / CSV)

Cálculo real de tarifas avanzadas

Búsqueda por nombre

Refactorización hacia MVC (opcional)

---

### 👨‍💻 Autor

David Cuadra Lara
Proyecto académico – DAM (2025)