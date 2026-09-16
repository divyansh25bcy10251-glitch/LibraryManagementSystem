package services;

import models.Book;
import utils.DataStorage;

import java.util.Collection;
import java.util.Map;

public class Inventory {
    private Map<String, Book> books;

    public Inventory() {
        books = DataStorage.loadBooks();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        save();
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
        save();
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public void save() {
        DataStorage.saveBooks(books);
    }
}
