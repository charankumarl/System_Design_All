package LowLevelDesign.Design_Ola_Uber.Trip;

import LowLevelDesign.Design_Ola_Uber.Driver.Location;
import LowLevelDesign.Design_Ola_Uber.Rating;

public class TripMetaData {

    Location from;
    Location to;
    Rating rating;

    public TripMetaData(Location from, Location to, Rating rating) {
        this.from = from;
        this.to = to;
        this.rating = rating;
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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
