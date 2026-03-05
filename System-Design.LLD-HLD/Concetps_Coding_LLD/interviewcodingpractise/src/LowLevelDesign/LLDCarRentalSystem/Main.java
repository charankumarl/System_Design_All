package LowLevelDesign.LLDCarRentalSystem;

import LowLevelDesign.LLDCarRentalSystem.Product.Car;
import LowLevelDesign.LLDCarRentalSystem.Product.Vehicle;
import LowLevelDesign.LLDCarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location(403012, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);  // gets full vehicle lists.


        //3.reserving the particular vehicle
       Reservation reservation = store.createReservation(storeVehicles.get(0), user);  // make reservation on any vehicle.

       //4. generate the bill
        Bill bill = new Bill(reservation);  // generate bill for reservation

        //5. make payment
        Payment payment = new Payment();   // make payment on bills.
        payment.payBill(bill);

       //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.reservationId);    // make reservation complete.

    }

    /*
                    FLOW

        1. User will come and search for the store based on location.

                1. we need to create USER object.
                2. We need to have LOCATION object.

        2. STORE object will contain all List of vehicles in that stores.

                1. It contains Location object.
                2. It also contains Vehicle Inv. Which manages all the vehicles.
                3. It contains the List of Resevation.

        3. ONCE reservation is Done. We generate bill anf do the payment.
     */

    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }

}
