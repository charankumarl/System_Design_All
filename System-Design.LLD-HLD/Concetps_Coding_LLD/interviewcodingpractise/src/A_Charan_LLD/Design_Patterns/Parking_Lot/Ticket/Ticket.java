package A_Charan_LLD.Design_Patterns.Parking_Lot.Ticket;

import A_Charan_LLD.Design_Patterns.Parking_Lot.Vehicle.Vehicle;

import java.util.Date;

public class Ticket {

    Date entryTime;
    int parkingSpotId;

    Vehicle vehicle;

    public Ticket(int parkingSpotId, Vehicle vehicle){
        this.vehicle = vehicle;
        this.entryTime = new Date();
        this.parkingSpotId = parkingSpotId;
    }

    public Date getEntryTime(){
        return entryTime;
    }

    public int getParkingSpotId(){
        return parkingSpotId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", parkingSpotId=" + parkingSpotId +
                ", vehicle=" + vehicle.toString() +
                '}';
    }
}
