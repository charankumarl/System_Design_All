package LowLevelDesign.MedicineDispenseSystem.entity;

import java.util.Date;

public class Tablet implements Medicine{

    String name;
    Date expirationDate;
    String dosage;
    int price;

    public Tablet(String name, java.util.Date expirationDate, String dosage, int price) {
        this.dosage = dosage;
        this.price = price;
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
