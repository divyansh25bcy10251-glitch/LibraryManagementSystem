package models;

public class Student extends User {
    private static final long serialVersionUID = 1L;
    private static final int BORROW_LIMIT = 3;

    public Student(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int getBorrowLimit() {
        return BORROW_LIMIT;
    }
}
