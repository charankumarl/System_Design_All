package Interfaces;

import InheritanceAndConstructors.A;
import InheritanceAndConstructors.B;

public class Client {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        // an interface type can refer to the object
        // of any class which has implemented the interface
        Stack stack = new ArrayStack();
        stack.push(5);
        stack = new LinkedListStack();
        stack.push(10);
        stack = new QueueStack();
        stack.push(15);

        Utility.someUtilityMethod(stack);
    }
}
