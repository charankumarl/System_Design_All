package SynchronizationIssue.AdderSubtractorSyncMethid;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        // same object of the lock should be passed to both the codes



        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Void> adderFuture = executorService.submit(adder);
        Future<Void> subtractorFuture = executorService.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(value.getX());

        Calculator calculator = new Calculator();
        calculator.subtract();
    }
}

// HW : void and Void are same
// after the class, figure out the difference