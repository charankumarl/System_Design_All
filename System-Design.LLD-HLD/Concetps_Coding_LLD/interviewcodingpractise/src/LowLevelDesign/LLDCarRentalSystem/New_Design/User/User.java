package LowLevelDesign.LLDCarRentalSystem.New_Design.User;

import LowLevelDesign.LLDCarRentalSystem.New_Design.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String email;
    private List<Reservation> reservations;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
    public int getId() {
        return id;
    }
}
