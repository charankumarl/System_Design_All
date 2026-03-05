package ProducerConsumer.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class Store {
//    we are going to have multiple items
    private ConcurrentLinkedDeque<Object> items = new ConcurrentLinkedDeque<>();
    private int MAX_SIZE = 5;

    // 5 producers came at the same time
    // produced 5 items but list was only able to digest 3

    public void add(Object item) {
        System.out.println("Item is being produced : " + items.size());
        items.add(item);
    }

    public void remove() {
        System.out.println("Item is being consumed : " + items.size());
        items.remove();
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public ConcurrentLinkedDeque<Object> getItems() {
        return items;
    }
}

// ArrayList is not thread safe
