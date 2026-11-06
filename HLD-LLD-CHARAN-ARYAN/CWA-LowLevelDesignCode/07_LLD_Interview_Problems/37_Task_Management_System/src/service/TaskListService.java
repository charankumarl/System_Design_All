package service;

import model.Task;
import model.TaskList;

import java.util.HashMap;
import java.util.Map;

public class TaskListService {
    private Map<String, TaskList> taskLists;
    private int nextId;

    public TaskListService() {
        this.taskLists = new HashMap<>();
        this.nextId = 1;
    }

    public TaskList createTaskList(String name) {
        String id = "TL" + nextId++;
        TaskList taskList = new TaskList(id, name);
        taskLists.put(id, taskList);
        return taskList;
    }

    public void addTaskToList(String tlid, Task task) {
        TaskList taskList = taskLists.get(tlid);
        if (taskList != null) {
            taskList.addTask(task);
        }
    }

    public TaskList getTaskList(String tlid) {
        return taskLists.get(tlid);
    }
}
