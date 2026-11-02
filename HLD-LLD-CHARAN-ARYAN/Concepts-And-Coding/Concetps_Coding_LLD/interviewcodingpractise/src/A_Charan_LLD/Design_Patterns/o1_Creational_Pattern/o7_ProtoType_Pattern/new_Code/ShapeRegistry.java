package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.new_Code;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {

    private static final Map<String, Shape> shapes = new HashMap<>();

    static {
        shapes.put("circle", new Circle(10));   /// created object 1 time. and createing clone object everytime when we call.
    }

    public static Shape getShape(String type){
        return shapes.get(type).clone();   /// get object and call clone method to create new object.
    }
}
