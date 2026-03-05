package Interfaces;

public class QueueStack implements Stack {
    @Override
    public void push(int x) {
        System.out.println("Data is pushed in QueueStack");
    }

    @Override
    public void pop() {
        System.out.println("Data is popped from QueueStack");
    }

    @Override
    public int top() {
        System.out.println("Data is top from QueueStack");
        return 0;
    }
}
