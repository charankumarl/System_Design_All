package LowLevelDesign.Design_Ola_Uber.PricingStratergy;

import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

public class Default implements PricingStratergy{

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {

        return 100.0;
    }
}
