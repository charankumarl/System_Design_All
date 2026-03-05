package LowLevelDesign.Design_Zerodha_Stock_Broker.User;

import java.util.*;

public class UserManager {

    static Map<Integer, User> userMap = new HashMap<>();

    public void addUser(int id, User user) {
        userMap.put(id, user);
    }

    public User getUser(int id) {
        return userMap.getOrDefault(id, null);
    }
}