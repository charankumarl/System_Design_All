package state.concrete;

import model.Status;
import model.Task;
import state.TaskState;

public class TodoState implements TaskState {
    @Override
    public void startProgress(Task task) {
        task.setState(new InProgressState());
    }

    @Override
    public void completeTask(Task task) {
        // not allowed from TODO
    }

    @Override
    public void reOpen(Task task) {
        // not allowed, already TODO
    }

    @Override
    public void cancel(Task task) {
        task.setState(new CancelledState());
    }

    @Override
    public Status getStatus() {
        return Status.TODO;
    }
}
