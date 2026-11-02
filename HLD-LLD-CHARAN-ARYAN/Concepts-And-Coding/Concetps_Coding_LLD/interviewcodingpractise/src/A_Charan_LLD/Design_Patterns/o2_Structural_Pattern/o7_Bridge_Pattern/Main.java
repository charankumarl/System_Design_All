package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern;

public class Main {

    public static void main(String[] args) {

        Shape redCircle = new Circcle(new RedColor());
        redCircle.draw();
    }
}
