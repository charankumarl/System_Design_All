package medicineDispensingSystem.entity;

import java.util.Date;

public class Syrup implements Medicine{

    int volume;
    int price;
    String name;
    Date expirationDate;
    String dosage = "1";

    public Syrup(String name, Date expirationDate, int volume, int price) {
        this.volume = volume;
        this.price = price;
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String getDosage() {
        return dosage;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

