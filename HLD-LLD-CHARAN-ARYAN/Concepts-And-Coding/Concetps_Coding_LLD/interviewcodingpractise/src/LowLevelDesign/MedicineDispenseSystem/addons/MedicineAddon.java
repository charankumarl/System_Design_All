package LowLevelDesign.MedicineDispenseSystem.addons;

import LowLevelDesign.MedicineDispenseSystem.entity.Medicine;

public abstract class MedicineAddon implements Medicine {

    Medicine medicine;

    public  MedicineAddon(Medicine medicine) {
        this.medicine = medicine;
    }
}

