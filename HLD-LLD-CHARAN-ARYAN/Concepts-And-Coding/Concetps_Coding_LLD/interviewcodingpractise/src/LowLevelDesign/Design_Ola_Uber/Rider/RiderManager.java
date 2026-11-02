package LowLevelDesign.Design_Ola_Uber.Rider;

import java.util.*;

public class RiderManager {

    List<Rider> riders = new ArrayList<>();

    private RiderManager() {
        // private constructor to prevent instantiation
    }

    private static RiderManager instance = null;

    public static RiderManager getInstance() {
        if (instance == null) {
            instance = new RiderManager();
        }
        return instance;
    }

    public void addRider(Rider rider) {
        riders.add(rider);
    }
}
