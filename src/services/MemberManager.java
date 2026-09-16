package services;

import models.User;
import utils.DataStorage;

import java.util.Collection;
import java.util.Map;

public class MemberManager {
    private Map<String, User> users;

    public MemberManager() {
        users = DataStorage.loadUsers();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        save();
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public void save() {
        DataStorage.saveUsers(users);
    }
}
