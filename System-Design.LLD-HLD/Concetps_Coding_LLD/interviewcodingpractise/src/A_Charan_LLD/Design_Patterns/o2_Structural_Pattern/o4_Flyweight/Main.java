package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight;

public class Main {

    public static void main(String[] args) {

        Shape redCircle = ShapeFactory.getCircle("Red");
        redCircle.setDetails(10, 10, 100);
        redCircle.draw();
        System.out.println(redCircle);         // Both have same object with default values. But only inique value changes

        Shape redCircle1 = ShapeFactory.getCircle("Red");
        redCircle1.setDetails(10, 10, 100);
        redCircle1.draw();
        System.out.println(redCircle1);


    }
}
