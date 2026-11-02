package medicineDispensingSystem.addon;

import medicineDispensingSystem.entity.Medicine;

public abstract class MedicineAddon implements Medicine {

    Medicine medicine;

   public  MedicineAddon(Medicine medicine) {
        this.medicine = medicine;
   }
}
