package LowLevelDesign.Design_Ola_Uber.Trip;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Driver.Location;
import LowLevelDesign.Design_Ola_Uber.Rider.Rider;

import java.time.LocalDate;

public class Trip {

    int id;
    Rider rider;
    Driver driver;
    Location from;
    Location to;
    double price;
    String status;

    public Trip(Rider rider) {
        this.rider = rider;
        this.from = rider.getFromLocation();
        this.to = rider.getToLocation();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
