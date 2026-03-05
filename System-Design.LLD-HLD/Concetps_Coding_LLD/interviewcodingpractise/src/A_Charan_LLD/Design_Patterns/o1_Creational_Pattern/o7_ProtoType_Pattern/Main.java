package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        Car_DeepCopy carDeepCopy = new Car_DeepCopy("Ford1", "Figo", 2015);
        System.out.println(carDeepCopy);

        //Car car1 = new Car("Ford1", "Figo", 2015); Instead of

        Car_DeepCopy carDeepCopy1 = carDeepCopy.clone();
        System.out.println(carDeepCopy1);
        carDeepCopy1.setBrand("Ford2");

        System.out.println(carDeepCopy);
        System.out.println(carDeepCopy1);

        System.out.println("---------------------------------------------------------------------------------");

        int arr[] = {1, 2, 3, 4, 5};
        Car_ShallowCopy carShallowCopy = new Car_ShallowCopy("Ford1", "Figo", 2015, arr);
        System.out.println(carShallowCopy);

        Car_ShallowCopy carShallowCopy1 = carShallowCopy.clone();
        System.out.println(carShallowCopy1);

        carShallowCopy1.getArr()[0] = 10; // modifying the array in shallow copy will also modify the original object

        System.out.println(carShallowCopy);
        System.out.println(carShallowCopy1);
    }
}
