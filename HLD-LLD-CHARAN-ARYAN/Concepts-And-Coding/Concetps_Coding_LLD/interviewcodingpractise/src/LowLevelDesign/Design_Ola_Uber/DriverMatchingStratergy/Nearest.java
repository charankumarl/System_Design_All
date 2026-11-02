package LowLevelDesign.Design_Ola_Uber.DriverMatchingStratergy;

import LowLevelDesign.Design_Ola_Uber.Driver.Driver;
import LowLevelDesign.Design_Ola_Uber.Trip.TripMetaData;

import java.util.List;

public class Nearest implements DriverMatchingStratergy{

    @Override
    public Driver matchDriver(TripMetaData tripMetaData, List<Driver> drivers) {

        for(int i = drivers.size()-1; i >= 0; i--){

            Driver driver = drivers.get(i);

            if(driver.isAvail() ){
                return driver;
            }
        }

        return null;
    }
}
