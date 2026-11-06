package sort.concrete;

import model.Task;
import sort.TaskSortStrategy;

import java.util.Comparator;
import java.util.List;

public class SortByPriority implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getPriority));
    }
}
