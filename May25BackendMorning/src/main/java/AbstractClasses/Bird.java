package AbstractClasses;

import Inheritance.Animal;

public abstract class Bird {
    private String name;
    private int noOfWings;

    public void eat(){
        System.out.println("Bird is eating");
    }

    public abstract void fly();
    public abstract void makeSound();
}

// 1. You can't create object of Abstract classes
// 2. Abstract classes can also have abstract methods
    // a. No definitions are required
    // b. It enforces child classes to have the definitions


// Static & final


