package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern;

public class main {

    public static void main(String[] args) {

        sample sample = new sample.Builder(1, "Car", 4)
                .add_Add1(100)
                .add_Add2(200)
                .build();

        System.out.println("ID: " + sample.id);
        System.out.println("Name: " + sample.name);
        System.out.println("Wheel: " + sample.wheel);

        System.out.println("Add1: " + sample.add1);
        System.out.println("Add2: " + sample.add2);
        System.out.println("Add3: " + sample.add3);
    }
}
