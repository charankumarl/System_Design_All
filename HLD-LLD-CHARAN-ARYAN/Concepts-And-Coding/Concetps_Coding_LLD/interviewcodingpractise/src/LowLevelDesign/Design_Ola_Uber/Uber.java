package LowLevelDesign.Design_Ola_Uber;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Driver.DriverManager;
import LowLevelDesign.Design_Ola_Uber.Driver.Location;
import LowLevelDesign.Design_Ola_Uber.Rider.Rider;
import LowLevelDesign.Design_Ola_Uber.Rider.RiderManager;
import LowLevelDesign.Design_Ola_Uber.Trip.Trip;
import LowLevelDesign.Design_Ola_Uber.Trip.TripManager;

import java.util.List;

public class Uber {

    public static void main(String[] args) {

        Driver driver1 = new Driver(1, "charanDriver", new Location(1, "kengeri"), true, Rating.FOUR);
        Driver driver2 = new Driver(2, "KumarDriver", new Location(2, "satellite"), true, Rating.ONE);

        Rider rider1 = new Rider(1, "charanRider","12334",
                new Location(1, "kengeri"), new Location(2, "satellite"), Rating.FOUR);

        Rider rider2 = new Rider(2, "KumarRider","12334",
                new Location(2, "satellite"), new Location(2, "kengeri"), Rating.ONE);

        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(driver1);
        driverManager.addDriver(driver2);

        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(rider1);
        riderManager.addRider(rider2);

        Trip trip1 = new Trip(rider1);
        Trip trip2 = new Trip(rider2);

        TripManager tripManager = new TripManager();
        tripManager.createTrip(trip1);
        tripManager.createTrip(trip2);

        List<Trip> trips = tripManager.getAllTrips();

        for(Trip trip : trips){
            System.out.println("Trip ID: " + trip.getId());
            System.out.println("Rider Name: " + trip.getRider().getName());
            System.out.println("Driver Name: " + trip.getDriver().getName());
            System.out.println("Trip Status: " + trip.getStatus());
            System.out.println("Price: " + trip.getPrice());
            System.out.println();
        }
        //---------------------------COMPLETE TRIP------------------------------------------------------//
        tripManager.completeTrip(trip1);
        tripManager.completeTrip(trip2);

        trips = tripManager.getAllTrips();
        for(Trip trip : trips){
            System.out.println("Trip ID: " + trip.getId());
            System.out.println("Rider Name: " + trip.getRider().getName());
            System.out.println("Driver Name: " + trip.getDriver().getName());
            System.out.println("Trip Status: " + trip.getStatus());
            System.out.println("Price: " + trip.getPrice());
            System.out.println();
        }

    }
}
