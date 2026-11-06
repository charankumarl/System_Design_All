package observer.concrete;

import model.ActivityLog;
import model.Task;
import observer.TaskObserver;

public class ActivityLogger implements TaskObserver {
    private final Task task;

    public ActivityLogger(Task task) {
        this.task = task;
    }

    @Override
    public void update(String change) {
        task.addActivityLog(new ActivityLog(change));
    }
}
