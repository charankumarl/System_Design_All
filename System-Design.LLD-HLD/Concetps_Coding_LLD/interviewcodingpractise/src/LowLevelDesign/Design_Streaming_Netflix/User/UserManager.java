package LowLevelDesign.Design_Streaming_Netflix.User;

import LowLevelDesign.Design_Streaming_Netflix.Authentication.Authentication;

import java.util.*;

public class UserManager {

    List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void login(String email, String password) {
        boolean validate = Authentication.login(email, password);
        if (validate) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void logout(int userId) {

        boolean validate = Authentication.logout(userId);
        if (validate) {
            System.out.println("Logged Out successful");
        } else {
            System.out.println("Invalid userId");
        }
    }
}
