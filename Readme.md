# 🧬 Game of Life – TDD Kata (Java 21 + JUnit 5)

This project is a **Test-Driven Development (TDD)** exercise implementing **Conway’s Game of Life** in **Java 21** with **JUnit 5**.

The goal is to practice clean design, incremental implementation, and automated testing.

---

## 🚀 Features (planned)

* 🧩 Pure Java 21 implementation (no external frameworks)
* 🧪 Full TDD approach with JUnit 5 tests
* 📜 Input from a `.txt` file representing the initial grid
* 🔁 Optional second argument: number of evolution cycles
* 📦 Output to console or optionally another `.txt` file
* ⚙️ Build and run via Maven

---

## 🧰 Requirements

* **Java 21** or higher
* **Maven 3.9+**
* (Optional) IntelliJ IDEA or any Java IDE

---

## ⚙️ Setup

Clone the repository:

```bash
git clone https://github.com/yourusername/game-of-life-tdd.git
cd game-of-life-tdd
```

Build and run tests:

```bash
mvn clean test
```

---

## ▶️ Run the program

Once built, you can generate a runnable JAR and run it as follows:

```bash
mvn package
java -jar target/game-of-life.jar initial_state.txt 10
```

* `initial_state.txt`: text file containing the initial grid
* `10`: *(optional)* number of evolution cycles (default = 1)

---

## 🧪 Example `initial_state.txt`

```
00000
00100
00100
00100
00000
```

`0` = dead cell
`1` = alive cell

---

## 📖 Project structure

```
src/
├── main/java/com/example/gameoflife/
│   ├── GameOfLife.java
│   ├── Board.java
│   └── Main.java
└── test/java/com/example/gameoflife/
    ├── GameOfLifeTest.java
    └── BoardTest.java
```

---

## 🧠 TDD Steps (suggested)

1. Write a failing test for a simple rule (e.g., underpopulation)
2. Implement the minimum code to pass the test
3. Refactor
4. Repeat for all Game of Life rules
5. Add integration tests for multiple generations
6. Finally, implement CLI and file parsing

---

## 📄 License

MIT License – feel free to fork, modify, and experiment!

---

*Made with ☕ and TDD.*
