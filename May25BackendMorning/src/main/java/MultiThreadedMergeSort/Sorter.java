package MultiThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToBeSorted;
    private ExecutorService executor;

    public Sorter(List<Integer> arrayToBeSorted, ExecutorService executor) {
        this.arrayToBeSorted = arrayToBeSorted;
        this.executor = executor;
    }
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Sorting is happening in :" + Thread.currentThread().getName());
        System.out.println("Array : " + arrayToBeSorted);
        if(arrayToBeSorted.size() <= 1){
            return arrayToBeSorted;
        }

        int size = arrayToBeSorted.size();

        int mid = size / 2;

        List<Integer> leftArray = arrayToBeSorted.subList(0, mid);
        List<Integer> rightArray = arrayToBeSorted.subList(mid, arrayToBeSorted.size());

        Sorter leftArraySorterTask = new Sorter(leftArray, executor);
        Sorter rightArraySorterTask = new Sorter(rightArray, executor);

        // Runnable : execute
        // Callable : submit
        Future<List<Integer>> leftArrayFuture  = executor.submit(leftArraySorterTask);
        Future<List<Integer>> rightArrayFuture = executor.submit(rightArraySorterTask);

        // get function would block the current thread until the data is ready and returned
        List<Integer> sortedLeftArray = leftArrayFuture.get();
        List<Integer> sortedRightArray = rightArrayFuture.get();

        // we need to merge

        int i= 0;
        int j = 0;

        List<Integer> sortedArray = new ArrayList<>();

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;
    }
}
