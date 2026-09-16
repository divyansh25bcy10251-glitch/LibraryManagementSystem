package services;

import exceptions.LibraryException;
import models.Book;
import models.User;

public class LibraryService {
    private Inventory inventory;
    private MemberManager memberManager;

    public LibraryService(Inventory inventory, MemberManager memberManager) {
        this.inventory = inventory;
        this.memberManager = memberManager;
    }

    public void checkoutBook(String userId, String isbn) throws LibraryException {
        User user = memberManager.getUser(userId);
        if (user == null) {
            throw new LibraryException("User not found with ID: " + userId);
        }

        Book book = inventory.getBook(isbn);
        if (book == null) {
            throw new LibraryException("Book not found with ISBN: " + isbn);
        }

        if (!book.isAvailable()) {
            throw new LibraryException("Book is currently unavailable.");
        }

        if (user.getBorrowedBookIsbns().size() >= user.getBorrowLimit()) {
            throw new LibraryException("User has reached their borrowing limit of " + user.getBorrowLimit() + " books.");
        }

        book.setAvailable(false);
        user.borrowBook(isbn);

        inventory.save();
        memberManager.save();
    }

    public void returnBook(String userId, String isbn) throws LibraryException {
        User user = memberManager.getUser(userId);
        if (user == null) {
            throw new LibraryException("User not found with ID: " + userId);
        }

        Book book = inventory.getBook(isbn);
        if (book == null) {
            throw new LibraryException("Book not found with ISBN: " + isbn);
        }

        if (!user.getBorrowedBookIsbns().contains(isbn)) {
            throw new LibraryException("User has not borrowed this book.");
        }

        book.setAvailable(true);
        user.returnBook(isbn);

        inventory.save();
        memberManager.save();
    }
}
