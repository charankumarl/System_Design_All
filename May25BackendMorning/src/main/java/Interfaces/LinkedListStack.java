package Interfaces;

public class LinkedListStack implements Stack{
    @Override
    public void push(int x) {
        System.out.println("Data is pushed in LinkedListStack");
    }

    @Override
    public void pop() {

    }

    @Override
    public int top() {
        return 0;
    }
}
