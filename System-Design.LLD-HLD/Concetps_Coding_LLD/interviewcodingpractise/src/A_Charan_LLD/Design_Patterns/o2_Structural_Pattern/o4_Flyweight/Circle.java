package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight;

public class Circle implements Shape{

    private String color; // Shared data.  Common for all object if color is same.   Intrinsic state

    private int x, y, radius; // Unique data.   Extrinsic state

    public Circle(String color) {
        this.color = color;
    }

    public void setDetails(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        System.out.println("Drawing " + color + " Circle at (" + x + "," + y + ") with radius " + radius);
    }

}
