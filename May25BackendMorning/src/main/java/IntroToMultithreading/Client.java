package IntroToMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
    // Runnable
        System.out.println(Thread.currentThread().getName());
//        helloWorldPrinter.run();
        Thread t = new Thread(helloWorldPrinter);
        t.start(); // internally it calls obj.run()
        System.out.println("After creating the thread in " + Thread.currentThread().getName());

//        for(int i = 1; i <= 100; i++){
//            NumberPrinter numberPrinter = new NumberPrinter(i);
//            Thread thread = new Thread(numberPrinter);
//            thread.start();
//        }


        // we don't want to create a new thread for every task
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 1; i <= 100; i++){
//            if(i == 80000){
//                System.out.println();
//            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }
        System.out.println();
    }
}

// Thread
// start () {    run()           }
// Runnable interface : run()

// HW : Print 1 -> 100
// every number should be printed in a different thread
