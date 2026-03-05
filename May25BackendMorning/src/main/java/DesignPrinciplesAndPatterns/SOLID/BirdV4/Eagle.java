package DesignPrinciplesAndPatterns.SOLID.BirdV4;

public class Eagle extends Bird implements Flyable {
    HighFlying highFlying;
    Eagle(){
        highFlying = new HighFlying();
    }
    @Override
    public void fly() {
//        System.out.println("Flying High");
        highFlying.flyHigh();
    }

    @Override
    public void makeSound() {

    }
}
