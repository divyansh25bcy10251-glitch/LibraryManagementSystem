package models;

public class Faculty extends User {
    private static final long serialVersionUID = 1L;
    private static final int BORROW_LIMIT = 5;

    public Faculty(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int getBorrowLimit() {
        return BORROW_LIMIT;
    }
}
