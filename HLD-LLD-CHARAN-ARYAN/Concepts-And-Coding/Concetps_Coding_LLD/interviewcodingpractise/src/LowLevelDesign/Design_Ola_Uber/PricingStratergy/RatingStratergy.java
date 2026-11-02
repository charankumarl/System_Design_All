package LowLevelDesign.Design_Ola_Uber.PricingStratergy;

import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

public class RatingStratergy implements PricingStratergy{

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        return 50.0;
    }
}
