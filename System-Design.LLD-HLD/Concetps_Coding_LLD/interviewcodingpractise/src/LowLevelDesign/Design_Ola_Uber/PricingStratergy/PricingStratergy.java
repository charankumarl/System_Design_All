package LowLevelDesign.Design_Ola_Uber.PricingStratergy;

import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

public interface PricingStratergy {

    public double calculatePrice(TripMetaData tripMetaData);
}
