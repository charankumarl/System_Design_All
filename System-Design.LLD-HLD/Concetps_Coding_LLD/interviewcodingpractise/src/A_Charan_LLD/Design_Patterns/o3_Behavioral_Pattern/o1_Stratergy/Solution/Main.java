package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bike sports_bike = new Bike(GearType.MANUAL);
        sports_bike.gear();

        Bike scooty = new Bike(GearType.AUTOMATIC);  // Both scooty and electric have same gear system. Uses automatic gear class
        scooty.gear();

        Bike electric = new Bike(GearType.AUTOMATIC);  // no duplication of code.
        electric.gear();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of gear (MANUAL/AUTOMATIC): ");
        String input = sc.nextLine().toLowerCase();
        GearType gearType = null;

        switch (input) {
            case "manual":
                gearType = GearType.MANUAL;
                break;
            case "automatic":
                gearType = GearType.AUTOMATIC;
                break;
            default:
                System.out.println("Invalid input. Defaulting to AUTOMATIC gear.");
        }

        sports_bike = new Bike(gearType);
        sports_bike.gear();

    }// without if else decided the gear system dynamically
}
