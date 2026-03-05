package ProducerConsumer.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store();
        Semaphore prodSema = new Semaphore(5);
        Semaphore consSema = new Semaphore(0);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 10; i ++){
            executorService.execute(new Producer(store, prodSema , consSema));
        }

        for(int i = 0 ; i < 10; i ++){
            executorService.execute(new Consumer(store, prodSema , consSema));
        }
    }
}
