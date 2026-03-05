package Interfaces;

public interface Stack {
    // static & final data members => constant
    void push(int x);
    void pop();
    int top();

    default int size(){
        return top();
    }
}
