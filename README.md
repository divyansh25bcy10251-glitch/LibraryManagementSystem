# University Library Management System

## Overview
A Java-based console application designed to manage the core operations of a university library. It allows for robust inventory management, member registration (Students and Faculty), and automated book checkouts/returns with built-in validation and borrowing limits.

## Features
- **Inventory Management:** Add, remove, and list books in the system.
- **Member Management:** Differentiate between Students (max 3 books) and Faculty (max 5 books).
- **Transaction Engine:** Handle borrowing and returning with automatic state updates.
- **Data Persistence:** Saves all books and users locally so state isn't lost when the application is closed.
- **Exception Handling:** Robust validation to prevent borrowing unavailable books or exceeding limits.

## Technologies Used
- Java 11+
- File I/O for data storage
- Object-Oriented Design (Inheritance, Polymorphism)

## Steps to Install & Run
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Clone or download this repository.
3. Open a terminal and navigate to the `src` directory of the project.
4. Compile the source code:
   `javac main/Main.java`
5. Run the application:
   `java main.Main`

## Testing Instructions
1. Run the application.
2. Select option `1` to add a new book to the catalog.
3. Select option `4` to register a new Student or Faculty member.
4. Try borrowing the book using option `6` (Checkout).
5. Attempt to borrow the same book again to verify the error handling.
6. Return the book using option `7` and verify the status is updated.
7. Exit the application and run it again to verify that data was persisted.
