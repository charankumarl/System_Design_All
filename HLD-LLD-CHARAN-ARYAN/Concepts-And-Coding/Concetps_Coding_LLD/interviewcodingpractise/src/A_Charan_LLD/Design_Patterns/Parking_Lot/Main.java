package A_Charan_LLD.Design_Patterns.Parking_Lot;

import A_Charan_LLD.Design_Patterns.Parking_Lot.CostCompute.*;
import A_Charan_LLD.Design_Patterns.Parking_Lot.Entrance_Gate.Entrance_Gate;
import A_Charan_LLD.Design_Patterns.Parking_Lot.ParkingSpot.*;
import A_Charan_LLD.Design_Patterns.Parking_Lot.Ticket.Ticket;
import A_Charan_LLD.Design_Patterns.Parking_Lot.Vehicle.Type;
import A_Charan_LLD.Design_Patterns.Parking_Lot.Vehicle.Vehicle;

public class Main {

    public static void main(String[] args) {

        Parking_Spot_Manager fourWheelManager = new Parking_Spot_Manager_Four_Wheel();

        Four_Wheeler_Spot spot1 = new Four_Wheeler_Spot(1);
        Four_Wheeler_Spot spot2 = new Four_Wheeler_Spot(2);

        fourWheelManager.add(spot1);
        fourWheelManager.add(spot2);

        Parking_Spot_Manager twoWheelManager = new Parking_Spot_Manager_Two_Wheel();

        Two_Wheeler_Spot spot3 = new Two_Wheeler_Spot(1);
        Two_Wheeler_Spot spot4 = new Two_Wheeler_Spot(2);

        twoWheelManager.add(spot3);
        twoWheelManager.add(spot4);

        Entrance_Gate entranceGate = new Entrance_Gate(twoWheelManager);

        int spotnumber = entranceGate.findSpace();
        entranceGate.park(spotnumber);

        Ticket ticket = entranceGate.generateTicket(spotnumber, new Vehicle("KA-01-HH-1234", Type.BIKE));

        System.out.println("Ticket Number: " + ticket.toString());

        Cost_Compute cost = Cost_Compute_Facotry.getCostCompute("two wheelers Hours");
        cost.price(120);
    }
}
