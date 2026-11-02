package LowLevelDesign.Design_Ola_Uber.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {

    public static List<Driver> drivers = new ArrayList<>();

    private DriverManager() {
    }

    private static DriverManager instance = null;

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
}
