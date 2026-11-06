package medicineDispensingSystem.addon;

import medicineDispensingSystem.entity.Medicine;

public class DosageAddon extends MedicineAddon {

    public DosageAddon(Medicine medicine) {
        super(medicine);
    }

    @Override
    public int getPrice() {
        return medicine.getPrice() + 10;
    }

    @Override
    public String getDosage() {
        return medicine.getDosage() + "exttra dossage";
    }
}
