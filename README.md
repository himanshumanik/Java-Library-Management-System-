# Library Management System (OOP) 📚

This repository contains the solution for **Task 3: Library Management System**.

## Objective

The goal was to develop a mini Library Management System using Object-Oriented Programming (OOP) principles in Java, demonstrating class interaction and encapsulation. The system is designed to manage book records and handle the core transactions of issuing and returning books.

## System Architecture (Classes)

The system is built upon three main classes:

1.  **`Book.java`**: Represents a physical book with properties like `title`, `author`, `isbn`, and an internal status (`isIssued`).
2.  **`User.java`**: Represents a library member with properties like `userId` and `name`. It also maintains a local list of `issuedBooks`.
3.  **`Library.java`**: Acts as the central **Controller**. It holds `ArrayList` collections of all `Book` and `User` objects and contains the main business logic for `issueBook()` and `returnBook()`.

## Core Features

* **Book Management**: Allows adding new books and users.
* **Encapsulation**: Book and User details are managed through getters/setters, and the internal lists are managed by the `Library` class.
* **Issue Logic**:
    * Finds the book by ISBN and the user by ID.
    * Fails if the book is already issued, the user/book is not found.
    * Updates the book's status and adds the book to the user's `issuedBooks` list.
* **Return Logic**:
    * Reverses the issue process.
    * Removes the book from the user's `issuedBooks` list.
    * Sets the book's status back to `isIssued = false`.

## How to Run

1.  Ensure all four files (`Book.java`, `User.java`, `Library.java`, and `Main.java`) are in the same folder.
2.  **Compile the Java files:**
    ```bash
    javac *.java
    ```
3.  **Run the main class:**
    ```bash
    java Main
    ```
