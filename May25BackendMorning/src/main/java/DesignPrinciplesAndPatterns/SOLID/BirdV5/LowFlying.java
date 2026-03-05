package DesignPrinciplesAndPatterns.SOLID.BirdV5;

import DesignPrinciplesAndPatterns.SOLID.BirdV4.Flyable;

public class LowFlying implements FlyingBehaviour {
    public void doFlying(){
        System.out.println("Flying Low");
    }
}
