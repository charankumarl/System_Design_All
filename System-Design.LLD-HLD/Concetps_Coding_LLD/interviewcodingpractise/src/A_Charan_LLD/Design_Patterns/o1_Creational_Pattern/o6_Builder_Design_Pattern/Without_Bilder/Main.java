package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern.Without_Bilder;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("BMW", 4);   // normal car without any additional features
        System.out.println(car);

        Car car1 = new Car("Audi", 4, true, true);  // car with additional features
        System.out.println(car1);
    }
}
