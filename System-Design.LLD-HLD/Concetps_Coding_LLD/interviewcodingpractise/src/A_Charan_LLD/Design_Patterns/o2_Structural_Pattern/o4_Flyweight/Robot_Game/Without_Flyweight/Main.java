package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Robot_Game.Without_Flyweight;

public class Main {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        for(int i = 1; i <= 1000; i++){

            Robot robot = new Robot(x+i, y+i, "human");
        }

        for(int i = 1; i <= 1000; i++){

            Robot robot = new Robot(x+i, y+i, "android");
        }
    }
}
