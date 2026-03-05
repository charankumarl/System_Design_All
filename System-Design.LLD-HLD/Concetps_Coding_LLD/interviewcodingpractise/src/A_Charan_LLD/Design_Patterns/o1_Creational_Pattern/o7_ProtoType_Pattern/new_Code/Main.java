package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.new_Code;

public class Main {

    public static void main(String[] args) {

        Shape s1 = ShapeRegistry.getShape("circle");
        Shape s2 = ShapeRegistry.getShape("circle");

        s1.draw();
        s2.draw();

        System.out.println(s1 == s2); // false (different objects)
    }
}
