package state.concrete;

import model.Status;
import model.Task;
import state.TaskState;

public class CancelledState implements TaskState {
    @Override
    public void startProgress(Task task) {
        // not allowed, task is CANCELLED (terminal state)
    }

    @Override
    public void completeTask(Task task) {
        // not allowed, task is CANCELLED (terminal state)
    }

    @Override
    public void reOpen(Task task) {
        // not allowed, task is CANCELLED (terminal state)
    }

    @Override
    public void cancel(Task task) {
        // already CANCELLED
    }

    @Override
    public Status getStatus() {
        return Status.CANCELLED;
    }
}
