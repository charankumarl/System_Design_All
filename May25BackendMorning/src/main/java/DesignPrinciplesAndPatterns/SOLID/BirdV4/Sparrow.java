package DesignPrinciplesAndPatterns.SOLID.BirdV4;

public class Sparrow extends Bird implements Flyable {
    LowFlying lowFlying;
    Sparrow(){
        lowFlying = new LowFlying();
    }
    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {
//        System.out.println("Flying Low");
        lowFlying.flyLow();
    }
}
