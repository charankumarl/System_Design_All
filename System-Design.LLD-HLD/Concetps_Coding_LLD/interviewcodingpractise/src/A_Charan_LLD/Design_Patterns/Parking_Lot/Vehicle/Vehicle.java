package A_Charan_LLD.Design_Patterns.Parking_Lot.Vehicle;

public class Vehicle {

    String vehicleNo;
    Type vehicle;

    public Vehicle(String vehicleNo, Type vehicle) {
        this.vehicleNo = vehicleNo;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
