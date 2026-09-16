package utils;

import models.Book;
import models.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final String BOOKS_FILE = "books.dat";
    private static final String USERS_FILE = "users.dat";

    public static void saveBooks(Map<String, Book> books) {
        saveData(books, BOOKS_FILE);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Book> loadBooks() {
        Object data = loadData(BOOKS_FILE);
        if (data instanceof Map) {
            return (Map<String, Book>) data;
        }
        return new HashMap<>();
    }

    public static void saveUsers(Map<String, User> users) {
        saveData(users, USERS_FILE);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, User> loadUsers() {
        Object data = loadData(USERS_FILE);
        if (data instanceof Map) {
            return (Map<String, User>) data;
        }
        return new HashMap<>();
    }

    private static void saveData(Object data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    private static Object loadData(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
