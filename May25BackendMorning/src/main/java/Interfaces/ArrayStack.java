package Interfaces;

public class ArrayStack extends ParentStack implements Stack {
    @Override
    public void push(int x) {
        System.out.println("Data is pushed in ArrayStack");
    }

    @Override
    public void pop() {

    }

    @Override
    public int top() {
        return 0;
    }

}
