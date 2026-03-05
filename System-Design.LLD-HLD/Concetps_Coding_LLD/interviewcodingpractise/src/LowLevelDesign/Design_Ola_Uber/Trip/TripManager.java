package LowLevelDesign.Design_Ola_Uber.Trip;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Driver.DriverManager;
import LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy.DriverMatchingStratergy;
import LowLevelDesign.Design_Ola_Uber.PricingStratergy.PricingStratergy;
import LowLevelDesign.Design_Ola_Uber.StratergyManager.StratergyManager;

import java.util.*;

public class TripManager {

    List<Trip> trips = new ArrayList<>();
    Map<Integer, Trip> userTripMap = new HashMap<>();

    StratergyManager stratergyManager = new StratergyManager();
    PricingStratergy pricingStratergy;
    DriverMatchingStratergy driverMatchingStratergy;

    public void createTrip(Trip trip){

        TripMetaData tripMetaData = new TripMetaData(trip.from, trip.to, trip.getRider().getRating());

        List<Driver> drivers = DriverManager.drivers;

        pricingStratergy = stratergyManager.getPricingStratergy(tripMetaData);
        driverMatchingStratergy = stratergyManager.getDriverMatchingStratergy(tripMetaData, drivers);

        double price = pricingStratergy.calculatePrice(tripMetaData);
        Driver driver = driverMatchingStratergy.matchDriver(tripMetaData, drivers);

        driver.setAvail(false);
        trip.setDriver(driver);
        trip.setId(new Random().nextInt(1000));
        trip.setPrice(price);
        trip.setStatus("INPROGRESS");

        trips.add(trip);
        userTripMap.put(trip.getRider().getId(), trip);

        System.out.println("Trip Created: " + "with Driver " + driver.getName() + " and price is: " + price);
    }

    public void completeTrip(Trip trip){

        trip.getDriver().setAvail(true);
        trip.setStatus("COMPLETED");
        trip.getDriver().setCurrLocation(trip.getTo());
    }

    public Trip getTrip(int userId){

        return userTripMap.get(userId);
    }

    public List<Trip> getAllTrips(){

        return trips;
    }
}
