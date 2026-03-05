package DesignPrinciplesAndPatterns.SOLID.BirdV5;

public class Pegion extends Bird implements Flyable {
    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {
        System.out.println("Flying Low");
    }
}
