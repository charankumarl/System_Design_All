package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Robot_Game.With_FlyWeight;

class Andriod_Robot implements IRobot{

    private String type;

    public Andriod_Robot(String type) {
        this.type = type;
    }

    @Override
    public void display(int x, int y) {
        System.out.println(x + " " + y);
    }
}
