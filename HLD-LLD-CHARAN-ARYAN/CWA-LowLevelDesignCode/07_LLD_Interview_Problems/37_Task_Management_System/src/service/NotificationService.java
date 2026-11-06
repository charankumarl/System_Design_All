package service;

import model.Task;
import model.User;
import observer.TaskObserver;

public class NotificationService {

    public void send(Task task, String change) {
        for (TaskObserver observer : task.getObservers()) {
            observer.update(change);
        }

        User assignee = task.getAssignee();
        if (assignee != null) {
            for (TaskObserver channel : assignee.getChannels()) {
                channel.update(change);
            }
        }
    }
}
