package LowLevelDesign.Design_Streaming_Netflix.User;

import LowLevelDesign.Design_Streaming_Netflix.Streaming.Stream;
import LowLevelDesign.Design_Streaming_Netflix.Subscription.Subscription;

import java.util.ArrayList;
import java.util.List;

public class User {

    int userId;
    String name;
    String email;
    String password;
    Subscription subscription;
    List<Profile> profiles;
    List<Stream> history;

    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profiles = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Stream> getHistory() {
        return history;
    }

    public void setHistory(List<Stream> history) {
        this.history = history;
    }
}
