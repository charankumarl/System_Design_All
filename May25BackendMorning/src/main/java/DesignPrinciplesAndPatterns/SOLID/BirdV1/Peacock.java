package DesignPrinciplesAndPatterns.SOLID.BirdV1;

public class Peacock extends Bird {
    @Override
    public void fly() {
        System.out.println("Peacock is flying");
    }

    @Override
    public void makeSound() {
        System.out.println("EWEWEWEEWEWEW");
    }
}
