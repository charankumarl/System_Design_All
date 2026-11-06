package state.concrete;

import model.Status;
import model.Task;
import state.TaskState;

public class DoneState implements TaskState {
    @Override
    public void startProgress(Task task) {
        // not allowed from DONE
    }

    @Override
    public void completeTask(Task task) {
        // not allowed, already DONE
    }

    @Override
    public void reOpen(Task task) {
        task.setState(new TodoState());
    }

    @Override
    public void cancel(Task task) {
        // not allowed, already DONE
    }

    @Override
    public Status getStatus() {
        return Status.DONE;
    }
}
