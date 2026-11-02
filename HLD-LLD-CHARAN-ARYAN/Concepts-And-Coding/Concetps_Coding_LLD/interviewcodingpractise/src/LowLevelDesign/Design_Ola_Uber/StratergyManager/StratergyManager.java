package LowLevelDesign.Design_Ola_Uber.StratergyManager;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Driver.DriverManager;
import LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy.DriverMatchingStratergy;
import LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy.Nearest;
import LowLevelDesign.Design_Ola_Uber.PricingStratergy.Default;
import LowLevelDesign.Design_Ola_Uber.PricingStratergy.PricingStratergy;
import LowLevelDesign.Design_Ola_Uber.PricingStratergy.RatingStratergy;
import LowLevelDesign.Design_Ola_Uber.Rating;
import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

import java.util.List;

public class StratergyManager {

    private PricingStratergy pricingStratergy;
    private DriverMatchingStratergy driverMatchingStratergy;

    public PricingStratergy getPricingStratergy(TripMetaData tripMetaData){

        if(tripMetaData.getRating() == Rating.FOUR || tripMetaData.getRating() == Rating.FIVE){
            return new RatingStratergy();
        }

        return new Default();
    }

    public DriverMatchingStratergy getDriverMatchingStratergy(TripMetaData tripMetaData, List<Driver> driverList){

        if(tripMetaData.getFrom().getZipCode() <= 10){
            return new Nearest();
        }

        return new LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy.Default();
    }
}
