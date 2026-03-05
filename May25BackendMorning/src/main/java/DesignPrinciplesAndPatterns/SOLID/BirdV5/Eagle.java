package DesignPrinciplesAndPatterns.SOLID.BirdV5;

public class Eagle extends Bird implements Flyable {
    FlyingBehaviour flyingBehaviour;
    Eagle(){
        flyingBehaviour = new HighFlying();
    }
    @Override
    public void fly() {
//        System.out.println("Flying High");
        flyingBehaviour.doFlying();
    }

    @Override
    public void makeSound() {

    }
}
