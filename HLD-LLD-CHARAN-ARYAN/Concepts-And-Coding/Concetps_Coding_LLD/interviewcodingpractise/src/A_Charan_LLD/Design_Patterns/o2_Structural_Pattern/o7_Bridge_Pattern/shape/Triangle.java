package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern;

public class Triangle extends Shape{

    public Triangle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Traingle drawn with color ");
        color.applyColor();
    }
}
