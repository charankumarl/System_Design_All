package model;

import observer.TaskObserver;
import state.TaskState;
import state.concrete.TodoState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task {
    private String id;
    private String title;
    private String desc;
    private LocalDate dueDate;
    private LocalDateTime createDate;
    private User createdBy;
    private User assignee;
    private Priority priority;
    private TaskState currstate;
    private Set<Tag> tags;
    private List<Comment> comments;
    private List<Task> childTasks;
    private List<ActivityLog> activityLogs;
    private List<TaskObserver> observers;

    private Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.desc = builder.desc;
        this.dueDate = builder.dueDate;
        this.createdBy = builder.createdBy;
        this.assignee = builder.assignee;
        this.priority = builder.priority;
        this.createDate = LocalDateTime.now();
        this.currstate = new TodoState();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.childTasks = new ArrayList<>();
        this.activityLogs = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void setAssignee(User user) {
        this.assignee = user;
    }

    public void setState(TaskState state) {
        this.currstate = state;
    }

    public Status getStatus() {
        return currstate.getStatus();
    }

    public void startTask() {
        currstate.startProgress(this);
    }

    public void completeTask() {
        currstate.completeTask(this);
    }

    public void reOpenTask() {
        currstate.reOpen(this);
    }

    public void cancelTask() {
        currstate.cancel(this);
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public List<TaskObserver> getObservers(){
        return observers;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addChildTask(Task task) {
        childTasks.add(task);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addActivityLog(ActivityLog log) {
        activityLogs.add(log);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<ActivityLog> getActivityLogs() {
        return activityLogs;
    }

    public static class Builder {
        private String id;
        private String title;
        private String desc;
        private LocalDate dueDate;
        private User createdBy;
        private User assignee;
        private Priority priority;

        public Builder(String id, String title, User createdBy) {
            this.id = id;
            this.title = title;
            this.createdBy = createdBy;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder assignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
