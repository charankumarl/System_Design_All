package service;

import model.User;
import observer.TaskObserver;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;
    private int nextId;

    public UserService() {
        this.users = new HashMap<>();
        this.nextId = 1;
    }

    public User createUser(String name, String email) {
        String id = "U" + nextId++;
        User user = new User(id, name, email);
        users.put(id, user);
        return user;
    }

    public User getUser(String uid) {
        return users.get(uid);
    }

    public void addNotificationChannel(String uid, TaskObserver channel) {
        User user = users.get(uid);
        if (user != null) {
            user.addChannel(channel);
        }
    }
}
