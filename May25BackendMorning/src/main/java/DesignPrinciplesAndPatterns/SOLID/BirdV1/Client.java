package DesignPrinciplesAndPatterns.SOLID.BirdV1;

import java.util.List;

public class Client {

    public static void doSomething(List<Bird> birds){
        for(Bird bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {

    }
}
