package DesignPrinciplesAndPatterns.SOLID.BirdV5;

public class Crow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying Low");
    }

    @Override
    public void makeSound() {

    }
}
