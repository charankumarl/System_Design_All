package medicineDispensingSystem;

import medicineDispensingSystem.addon.DosageAddon;
import medicineDispensingSystem.entity.Medicine;
import medicineDispensingSystem.entity.Syrup;
import medicineDispensingSystem.entity.Tablet;

public class Main {

    public static void main(String[] args) {

        Medicine tablet = new Tablet("tab1", new java.util.Date(), "500", 50);
        Medicine syrup = new Syrup("syrup1", new java.util.Date(), 50, 50);

        System.out.println(tablet.getPrice());
        tablet = new DosageAddon(tablet);

        System.out.println(tablet.getPrice());
    }
}
