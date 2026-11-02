package LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Driver.DriverManager;
import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

import java.util.List;

public class Default implements DriverMatchingStratergy {

    @Override
    public Driver matchDriver(TripMetaData tripMetaData, List<Driver> driverList) {

        for(Driver driver : driverList){
            if(driver.isAvail()){
                return driver;
            }
        }

        return null;
    }
}
