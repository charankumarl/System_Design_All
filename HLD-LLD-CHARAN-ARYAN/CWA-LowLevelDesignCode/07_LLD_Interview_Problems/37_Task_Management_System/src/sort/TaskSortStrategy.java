package sort;

import model.Task;

import java.util.List;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
