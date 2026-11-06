import model.Priority;
import model.Status;
import model.Task;
import model.TaskList;
import model.User;
import observer.TaskObserver;
import service.NotificationService;
import service.TaskListService;
import service.TaskService;
import service.UserService;
import sort.TaskSortStrategy;

import java.time.LocalDate;
import java.util.List;

public class TaskManagementSys {

    private UserService userService;
    private TaskService taskService;
    private TaskListService taskListService;

    public TaskManagementSys() {
        NotificationService notificationService = new NotificationService();
        this.userService = new UserService();
        this.taskService = new TaskService(notificationService);
        this.taskListService = new TaskListService();
    }

    public User createUser(String name, String email) {
        return userService.createUser(name, email);
    }

    public void addNotificationChannel(String uid, TaskObserver channel) {
        userService.addNotificationChannel(uid, channel);
    }

    public TaskList createTaskList(String name) {
        return taskListService.createTaskList(name);
    }

    public Task createTask(String title, String desc, User createdBy, User assignee, LocalDate dueDate, Priority priority) {
        return taskService.createTask(title, desc, createdBy, assignee, dueDate, priority);
    }

    public void addTaskToList(String tlid, Task task) {
        taskListService.addTaskToList(tlid, task);
    }

    public void assignTask(String tid, User user) {
        Task task = taskService.getTask(tid);
        if (task != null) {
            task.setAssignee(user);
        }
    }

    public void startTask(String tid) {
        taskService.startTask(tid);
    }

    public void completeTask(String tid) {
        taskService.completeTask(tid);
    }

    public void reOpenTask(String tid) {
        taskService.reOpenTask(tid);
    }

    public void cancelTask(String tid) {
        taskService.cancelTask(tid);
    }

    public List<Task> getAllTaskByUserId(String uid) {
        return taskService.getAllTasksByUser(uid);
    }

    public List<Task> listTaskByStatus(Status status) {
        return taskService.listTasksByStatus(status);
    }

    public void deleteTask(String tid) {
        taskService.deleteTask(tid);
    }

    public List<Task> searchTask(String keyword, TaskSortStrategy strategy) {
        List<Task> result = taskService.searchTasks(keyword);
        if (strategy != null) {
            strategy.sort(result);
        }
        return result;
    }
}
