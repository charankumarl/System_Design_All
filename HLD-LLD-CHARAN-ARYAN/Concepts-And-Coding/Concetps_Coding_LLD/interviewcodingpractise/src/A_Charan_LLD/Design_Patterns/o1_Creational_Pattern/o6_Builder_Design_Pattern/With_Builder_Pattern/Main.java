package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern.With_Builder_Pattern;

public class Main {

    public static void main(String[] args) {

        Car car = new Car.Builder("BMW", 4).addAirbags()
                            .addMusicSystem().build();

        System.out.println(car);

        Car car1 = new Car.Builder("BMW", 4).addAirbags().build();


        // same as below

        Car.Builder b = new Car.Builder("BMW", 4);
        b.addAirbags();
        b.addMusicSystem();
    }
}
