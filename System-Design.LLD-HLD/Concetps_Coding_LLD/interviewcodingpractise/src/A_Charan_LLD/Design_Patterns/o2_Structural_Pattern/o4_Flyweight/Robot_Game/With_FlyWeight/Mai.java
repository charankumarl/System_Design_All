package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Robot_Game.With_FlyWeight;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Robot_Game.Without_Flyweight.Robot;

public class Mai {

    public static void main(String[] args) {

        IRobot human = Robot_Factory.createRobot("human");
        human.display(1, 1);

        IRobot human2 = Robot_Factory.createRobot("human");
        human2.display(2, 2);

        /*
            Create Object only once and reuse the same object from cache.
         */
    }
}
