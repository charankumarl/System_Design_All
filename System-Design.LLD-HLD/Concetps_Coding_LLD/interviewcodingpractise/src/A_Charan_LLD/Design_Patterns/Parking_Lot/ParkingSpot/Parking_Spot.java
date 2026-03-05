package A_Charan_LLD.Design_Patterns.Parking_Lot.ParkingSpot;

import A_Charan_LLD.Design_Patterns.Parking_Lot.Vehicle.Type;

public class Parking_Spot {

    private int spotNumber;
    private boolean isOccupied;
    private Type vehicleType;

    public Parking_Spot(int spotNumber, Type vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int setSpotNumber() {
        return spotNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Type getType() {
        return vehicleType;
    }

    public void setType(Type vehicleType) {
        this.vehicleType = vehicleType;
    }
}
