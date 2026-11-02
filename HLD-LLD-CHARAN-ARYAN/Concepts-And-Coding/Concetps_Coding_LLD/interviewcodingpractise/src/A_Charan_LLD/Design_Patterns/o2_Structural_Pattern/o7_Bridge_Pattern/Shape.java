package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o7_Bridge_Pattern;

public abstract class Shape{

    Color color;

    Shape(Color color){
        this.color = color;
    }

    public abstract void draw();
}
