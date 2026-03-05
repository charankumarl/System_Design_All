package A_Charan_LLD.Design_Patterns.Parking_Lot.ParkingSpot;

public interface Parking_Spot_Manager{

    void add(Parking_Spot parkingSpot);
    void remove(Parking_Spot parkingSpot);
    int find();
    void park(int spotNumber);
    void removePark(int spotNumber);
}
