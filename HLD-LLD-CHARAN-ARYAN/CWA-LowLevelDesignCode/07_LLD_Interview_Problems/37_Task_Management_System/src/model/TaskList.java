package model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private String id;
    private String name;
    private List<Task> tasks;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("TaskList: " + name);
        for (Task task : tasks) {
            System.out.println(" - " + task.getTitle() + " [" + task.getStatus() + "]");
        }
    }
}
