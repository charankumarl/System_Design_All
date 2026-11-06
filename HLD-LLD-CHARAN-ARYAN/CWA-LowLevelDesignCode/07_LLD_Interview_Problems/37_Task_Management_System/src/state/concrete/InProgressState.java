package state.concrete;

import model.Status;
import model.Task;
import state.TaskState;

public class InProgressState implements TaskState {
    @Override
    public void startProgress(Task task) {
        // not allowed, already IN_PROGRESS
    }

    @Override
    public void completeTask(Task task) {
        task.setState(new DoneState());
    }

    @Override
    public void reOpen(Task task) {
        // not allowed from IN_PROGRESS
    }

    @Override
    public void cancel(Task task) {
        task.setState(new CancelledState());
    }

    @Override
    public Status getStatus() {
        return Status.IN_PROGRESS;
    }
}
