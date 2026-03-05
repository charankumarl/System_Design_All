package ProducerConsumer.Semaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private Semaphore prodSema , consSema;
    public Producer(Store store, Semaphore prodSema , Semaphore consSema) {
        this.store = store;
        this.prodSema = prodSema;
        this.consSema  = consSema;
    }

    @Override
    public void run() {
//        any producer needs to constantly produce the item
        while (true) {
//            if(store.getMAX_SIZE() > store.getItems().size())
            try {
                // Step 1
                prodSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Step 2 : Complete the job
            store.add(new Object());

            // Step 3 : Signal
            consSema.release();

        }
    }
}
