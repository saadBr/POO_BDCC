# TP2 – Exception Handling and Banking System

This Java project is divided into two exercises: one for handling custom exceptions and another for simulating a banking system with inheritance and exception management.

---

## Exercise 1: Handling Custom Exception

### Description
Implements a class `EntierNaturel` that stores a natural number (zero or positive). If a negative value is set or decremented into, a custom exception `NombreNegatifException` is thrown.

### Features

- Encapsulates a non-negative integer
- Getter and setter methods
- Decrement with exception if resulting in a negative number
- Stores the erroneous value in the exception

### Screenshot
![EntierNaturel Run](images/1.png)
![Negative Value](images/2.png)
![Null Value](images/3.png)

---

## Exercise 2: Bank Account System

### Description
Implements a banking system with support for current and savings accounts, allowing deposits, withdrawals, and transfers. Custom exceptions are used to handle insufficient funds and nonexistent accounts.

### Features

- `CompteBancaire`: Abstract account class
- `CompteCourant`: Allows overdraft
- `CompteEpargne`: Generates interest
- Exception management:
  - `FondsInsuffisantsException`
  - `CompteInexistantException`
- Transfer between accounts
- Add or remove accounts from a list

### Screenshot

![Exception Cases](images/4.png)

---

## Technologies Used

- Java
- IntelliJ IDEA
- OOP principles
- Exception Handling

## 🗂️ Project Structure

```
TP2/
├── src/
│   ├── Exercice 1/
│   │   ├── EntierNaturel.java
│   │   └── NombreNegatifException.java
│
│   ├── Exercice 2/
│   │   ├── CompteBancaire.java
│   │   ├── CompteCourant.java
│   │   ├── CompteEpargne.java
│   │   ├── CompteInexistantException.java
│   │   ├── FondsInsuffisantsException.java
│   │   └── Main.java
│
├── images/
│   ├── 1.png ... 4.png
└── README.md
```

---

## 🚀 Run Project

### Compiler :
```bash
javac src/**/*.java
```

### Execute :
```bash
java src/Main
```

---

## 👤 Author

Saad EL MABROUK
