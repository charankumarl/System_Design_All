package service;

import model.Priority;
import model.Status;
import model.Task;
import model.User;
import observer.concrete.ActivityLogger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks;
    private int nextId;
    private NotificationService notificationService;

    public TaskService(NotificationService notificationService) {
        this.tasks = new HashMap<>();
        this.nextId = 1;
        this.notificationService = notificationService;
    }

    public Task createTask(String title, String desc, User createdBy, User assignee, LocalDate dueDate, Priority priority) {
        String id = "T" + nextId++;
        Task task = new Task.Builder(id, title, createdBy)
                .desc(desc)
                .assignee(assignee)
                .dueDate(dueDate)
                .priority(priority)
                .build();
        task.addObserver(new ActivityLogger(task));
        tasks.put(id, task);
        return task;
    }

    public void startTask(String tid) {
        Task task = tasks.get(tid);
        if (task == null) {
            return;
        }
        task.startTask();
        notificationService.send(task, "Task started");
    }

    public void completeTask(String tid) {
        Task task = tasks.get(tid);
        if (task == null) {
            return;
        }
        task.completeTask();
        notificationService.send(task, "Task completed");
    }

    public void reOpenTask(String tid) {
        Task task = tasks.get(tid);
        if (task == null) {
            return;
        }
        task.reOpenTask();
        notificationService.send(task, "Task re-opened");
    }

    public void cancelTask(String tid) {
        Task task = tasks.get(tid);
        if (task == null) {
            return;
        }
        task.cancelTask();
        notificationService.send(task, "Task cancelled");
    }

    public Task getTask(String tid) {
        return tasks.get(tid);
    }

    public void deleteTask(String tid) {
        tasks.remove(tid);
    }

    public List<Task> getAllTasksByUser(String uid) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getAssignee() != null && task.getAssignee().getId().equals(uid)) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> listTasksByStatus(Status status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus() == status) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDesc().contains(keyword)) {
                result.add(task);
            }
        }
        return result;
    }
}
