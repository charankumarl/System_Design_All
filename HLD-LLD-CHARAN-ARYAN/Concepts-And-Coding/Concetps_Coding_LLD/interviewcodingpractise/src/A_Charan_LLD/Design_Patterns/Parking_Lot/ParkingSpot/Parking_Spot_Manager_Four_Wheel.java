package A_Charan_LLD.Design_Patterns.Parking_Lot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Parking_Spot_Manager_Four_Wheel implements Parking_Spot_Manager{

    private List<Parking_Spot> parkingSpots;

    public Parking_Spot_Manager_Four_Wheel() {
        this.parkingSpots = new ArrayList<>();
    }

    @Override
    public void add(Parking_Spot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    @Override
    public void remove(Parking_Spot parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    @Override
    public int find() {

        for (int i = 0; i < parkingSpots.size(); i++) {

            if (parkingSpots.get(i).isOccupied() == false) {

                return i;
            }
        }
        return -1; // Spot not found
    }

    @Override
    public void park(int spotNumber) {

        if (spotNumber != -1) {
            parkingSpots.get(spotNumber).setOccupied(true);
        }

        System.out.println("Parked at spot number: " + spotNumber);
    }

    @Override
    public void removePark(int spotNumber) {

        parkingSpots.get(spotNumber).setOccupied(false);
    }
}
