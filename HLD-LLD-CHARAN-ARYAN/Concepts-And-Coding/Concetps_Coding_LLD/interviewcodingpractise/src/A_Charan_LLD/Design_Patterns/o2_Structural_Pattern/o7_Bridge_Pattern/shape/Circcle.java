package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern.shape;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern.colour.Color;

public class Circcle extends Shape{

    public Circcle(Color color) {
        super(color);
    }

    public void draw(){
        System.out.print("Drawing Circle with color: ");
        color.applyColor();
    }
}
