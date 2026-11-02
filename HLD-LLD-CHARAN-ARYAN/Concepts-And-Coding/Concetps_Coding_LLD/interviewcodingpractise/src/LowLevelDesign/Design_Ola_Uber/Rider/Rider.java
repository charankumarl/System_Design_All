package LowLevelDesign.Design_Ola_Uber.Rider;

import LowLevelDesign.Design_Ola_Uber.Driver.Location;
import LowLevelDesign.Design_Ola_Uber.Rating;

public class Rider {

    int id;
    String name;
    String phoneNumber;
    Location fromLocation;
    Location toLocation;
    Rating rating;

    public Rider(int id, String name, String phoneNumber, Location fromLocation, Location toLocation, Rating rating) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
