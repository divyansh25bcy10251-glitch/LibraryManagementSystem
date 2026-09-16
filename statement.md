# Problem Statement
Manual tracking of library resources is inefficient, leading to misplaced books, inaccurate late fee calculations, and difficulty in managing member limits. The University Library Management System aims to automate the core operations of a library, ensuring data consistency and streamlined workflows.

# Scope of the Project
The project covers three main modules:
1. **Inventory Management**: Adding, removing, and querying book details.
2.  **Member Management**: Registering students and faculty with specific borrowing rules.
3.  **Transaction Management**: Processing checkouts and returns while enforcing business rules (e.g., borrowing limits).

Data is persisted locally using simple text-based data storage, ensuring that the system is reliable across application restarts.

# Target Users
- **Library Administrators/Librarians**: To manage the catalog and register members.
- **Students & Faculty Members**: As the entities interacting with the borrowing system (though the current interface is admin-focused).

# High-Level Features
- Object-Oriented design with clear separation between Students and Faculty.
- Enforcement of borrowing limits.
- Persisted data storage for books and members.
- Command-line interface for rapid interactions.
