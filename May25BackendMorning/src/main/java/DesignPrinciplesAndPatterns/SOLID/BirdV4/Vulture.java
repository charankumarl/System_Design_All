package DesignPrinciplesAndPatterns.SOLID.BirdV4;

import DesignPrinciplesAndPatterns.SOLID.BirdV3.Flyable;

public class Vulture extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying High");
    }

    @Override
    public void makeSound() {

    }
}
