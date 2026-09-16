package main;

import exceptions.LibraryException;
import models.Book;
import models.Faculty;
import models.Student;
import models.User;
import services.Inventory;
import services.LibraryService;
import services.MemberManager;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();
    private static MemberManager memberManager = new MemberManager();
    private static LibraryService libraryService = new LibraryService(inventory, memberManager);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- University Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Add Member (Student/Faculty)");
            System.out.println("5. List All Members");
            System.out.println("6. Checkout Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    addMember();
                    break;
                case 5:
                    listMembers();
                    break;
                case 6:
                    checkoutBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting system. Data has been saved.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Book book = new Book(isbn, title, author);
        inventory.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN to remove: ");
        String isbn = scanner.nextLine();
        inventory.removeBook(isbn);
        System.out.println("Book removed successfully (if it existed).");
    }

    private static void listBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : inventory.getAllBooks()) {
            System.out.println(b);
        }
    }

    private static void addMember() {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Type (1 for Student, 2 for Faculty): ");
        String type = scanner.nextLine();

        User user;
        if ("1".equals(type)) {
            user = new Student(id, name);
        } else if ("2".equals(type)) {
            user = new Faculty(id, name);
        } else {
            System.out.println("Invalid type.");
            return;
        }

        memberManager.addUser(user);
        System.out.println("Member added successfully.");
    }

    private static void listMembers() {
        System.out.println("\n--- Member List ---");
        for (User u : memberManager.getAllUsers()) {
            System.out.println(u);
        }
    }

    private static void checkoutBook() {
        System.out.print("Enter Member ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        try {
            libraryService.checkoutBook(userId, isbn);
            System.out.println("Book checked out successfully.");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter Member ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        try {
            libraryService.returnBook(userId, isbn);
            System.out.println("Book returned successfully.");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
