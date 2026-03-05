package LowLevelDesign.Design_Ola_Uber.Driver;

import LowLevelDesign.Design_Ola_Uber.Driver.Location;
import LowLevelDesign.Design_Ola_Uber.Rating;

public class Driver {

    int id;
    String name;
    Location currLocation;
    boolean isAvail;
    Rating rating;

    public Driver(int id, String name, Location currLocation, boolean isAvail, Rating rating) {
        this.id = id;
        this.name = name;
        this.currLocation = currLocation;
        this.isAvail = isAvail;
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

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public boolean isAvail() {
        return isAvail;
    }

    public void setAvail(boolean avail) {
        isAvail = avail;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
