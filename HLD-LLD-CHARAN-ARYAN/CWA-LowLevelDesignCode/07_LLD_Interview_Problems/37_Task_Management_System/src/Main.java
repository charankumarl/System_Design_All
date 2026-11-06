import model.Priority;
import model.Task;
import model.TaskList;
import model.User;
import observer.concrete.EmailChannel;
import sort.concrete.SortByPriority;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskManagementSys system = new TaskManagementSys();

        User alice = system.createUser("Alice", "alice@mail.com");
        User bob = system.createUser("Bob", "bob@mail.com");

        system.addNotificationChannel(alice.getId(), new EmailChannel(alice.getEmail()));
        system.addNotificationChannel(bob.getId(), new EmailChannel(bob.getEmail()));

        TaskList sprint1 = system.createTaskList("Sprint 1");

        Task task1 = system.createTask("Fix login bug", "Login fails for new users",
                alice, bob, LocalDate.now().plusDays(3), Priority.HIGH);
        Task task2 = system.createTask("Write docs", "API documentation",
                alice, bob, LocalDate.now().plusDays(7), Priority.LOW);

        system.addTaskToList(sprint1.getId(), task1);
        system.addTaskToList(sprint1.getId(), task2);

        // progress a task: TODO -> IN_PROGRESS -> DONE
        system.startTask(task1.getId());
        system.completeTask(task1.getId());
        System.out.println("task1 status: " + task1.getStatus());

        // cancel a task: TODO -> CANCELLED
        system.cancelTask(task2.getId());
        System.out.println("task2 status: " + task2.getStatus());

        sprint1.display();

        System.out.println("Activity log for task1:");
        for (var log : task1.getActivityLogs()) {
            System.out.println(" - " + log.getDesc());
        }

        List<Task> results = system.searchTask("Fix", new SortByPriority());
        System.out.println("Search results for 'Fix': " + results.size());
    }
}
