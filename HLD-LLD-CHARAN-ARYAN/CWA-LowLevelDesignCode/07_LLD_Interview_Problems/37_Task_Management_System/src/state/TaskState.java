package state;

import model.Status;
import model.Task;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reOpen(Task task);
    void cancel(Task task);
    Status getStatus();
}
