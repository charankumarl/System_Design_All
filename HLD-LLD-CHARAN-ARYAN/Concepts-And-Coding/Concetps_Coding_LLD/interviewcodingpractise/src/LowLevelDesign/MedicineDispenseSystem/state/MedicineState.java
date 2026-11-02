package LowLevelDesign.MedicineDispenseSystem.state;

import LowLevelDesign.MedicineDispenseSystem.MedicineContext;
import LowLevelDesign.MedicineDispenseSystem.addons.MedicineAddon;

public abstract class MedicineState {
    public abstract void addAddon(MedicineContext context, MedicineAddon addon);
    public abstract void pay(MedicineContext context);
    public abstract void dispense(MedicineContext context);
    public abstract void selectItem(String code);
}

