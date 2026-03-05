package SynchronizationIssue.AdderSubtractorSyncMethid;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    @Override
    public Void call() throws Exception {
//        add from 1->100
        for(long i = 0; i <=100000; i++){
//            synchronized (value){
//                value.setX(value.getX()+i);
            value.incrementX(i);
//            }
//            lock.unlock();
        }
        return null;
    }
}
