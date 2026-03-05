package org.example.P1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class o1_Call_Same_Method_Multiple_Times {

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * If we have VOID return type, then we use RUN ASYNC()
     */
    public CompletableFuture<Void> voidReturn(){

        return CompletableFuture.runAsync(() -> {         ///  run async for void return type

            System.out.println(Thread.currentThread().getName());
        }, executorService);
    }

    public static void main(String[] args) {

        o1_Call_Same_Method_Multiple_Times test = new o1_Call_Same_Method_Multiple_Times();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        futures.add(test.voidReturn());
        futures.add(test.voidReturn());
        futures.add(test.voidReturn());    ///1. Submitted all tasks

        ///  2. Convert to Array to get output.

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        /// 3. To make Thread Wait until we get result.

        all.join();

        /// 4. To print all data.
        for(CompletableFuture<Void> f : futures){
            f.join();
        }


        ///  5. To skip the main thread waiting.

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun( () -> {
            for(CompletableFuture<Void> f : futures){
                f.join();
            }
        });

        System.out.println("main thread ended");
    }
}
