package ProducerConsumer.Semaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore prodSema , consSema;
    public Consumer(Store store, Semaphore prodSema , Semaphore consSema) {
        this.store = store;
        this.prodSema = prodSema;
        this.consSema  = consSema;
    }
    @Override
    public void run() {
        while(true){
//            if items are available then consume
//            if(store.getItems().size() > 0){
            try {
                consSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.remove();

            prodSema.release();
//            }
        }
    }
}
