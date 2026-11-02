package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

    public static Shape getCircle(String color){

        if (!circleMap.containsKey(color)) {

            circleMap.put(color, new Circle(color));

            System.out.println("Created new " + color + " Circle");
        }
        return  circleMap.get(color);
    }
}
