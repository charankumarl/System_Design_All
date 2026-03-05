package LowLevelDesign.MedicineDispenseSystem;

import LowLevelDesign.MedicineDispenseSystem.addons.DosageAddon;
import LowLevelDesign.MedicineDispenseSystem.entity.Medicine;
import LowLevelDesign.MedicineDispenseSystem.entity.Syrup;
import LowLevelDesign.MedicineDispenseSystem.entity.Tablet;

public class Mian {

    public static void main(String[] args) {

        Medicine tablet = new Tablet("tab1", new java.util.Date(), "500", 50);
        Medicine syrup = new Syrup("syrup1", new java.util.Date(), 50, 50);

        System.out.println(tablet.getPrice());
        tablet = new DosageAddon(tablet);

        System.out.println(tablet.getPrice());
    }
}
