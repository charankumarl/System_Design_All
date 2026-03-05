package SynchronizationIssue.AdderSubtractorLocks;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value value;
    private Lock lock;
    public Adder(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
//        add from 1->100
        for(long i = 0; i <=100000; i++){
            lock.lock();
            value.setX(value.getX()+i);
            lock.unlock();
        }
        return null;
    }
}
