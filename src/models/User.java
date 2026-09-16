package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String name;
    private List<String> borrowedBookIsbns;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBookIsbns = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<String> getBorrowedBookIsbns() {
        return borrowedBookIsbns;
    }

    public void borrowBook(String isbn) {
        borrowedBookIsbns.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBookIsbns.remove(isbn);
    }

    public abstract int getBorrowLimit();

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedCount=" + borrowedBookIsbns.size() +
                ", limit=" + getBorrowLimit() +
                '}';
    }
}
