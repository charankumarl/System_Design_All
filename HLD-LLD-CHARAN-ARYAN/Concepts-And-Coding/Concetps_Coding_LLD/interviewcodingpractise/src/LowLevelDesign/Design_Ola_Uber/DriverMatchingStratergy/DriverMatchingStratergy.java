package LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

import java.util.List;

public interface DriverMatchingStratergy {

    public Driver matchDriver(TripMetaData tripMetaData, List<Driver> drivers);
}
