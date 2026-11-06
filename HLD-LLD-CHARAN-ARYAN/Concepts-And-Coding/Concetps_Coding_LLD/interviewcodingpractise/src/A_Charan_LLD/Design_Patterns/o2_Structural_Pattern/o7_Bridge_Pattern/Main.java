package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern.colour.RedColor;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern.shape.Circcle;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern.shape.Shape;

public class Main {

    public static void main(String[] args) {

        Shape redCircle = new Circcle(new RedColor());
        redCircle.draw();
    }
}
