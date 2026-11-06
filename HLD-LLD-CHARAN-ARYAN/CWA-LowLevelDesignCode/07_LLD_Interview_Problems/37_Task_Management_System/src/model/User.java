package model;

import observer.TaskObserver;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private List<TaskObserver> channels;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.channels = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addChannel(TaskObserver channel){
        this.channels.add(channel);
    }

    public List<TaskObserver> getChannels() {
        return channels;
    }
}
