package SynchronizationIssue.AdderSubtractorSyncMethid;

public class Calculator {
    synchronized void add(){
        System.out.println("Addition is performed by : " + Thread.currentThread().getName());
    }

    synchronized void subtract(){
        System.out.println("Subtraction is performed by : " + Thread.currentThread().getName());
        add();
    }

    synchronized void multiply(){

    }
}
