package LowLevelDesign.MedicineDispenseSystem;

import LowLevelDesign.DesignVendingMachine.Coin;
import LowLevelDesign.MedicineDispenseSystem.entity.Inventory;
import LowLevelDesign.MedicineDispenseSystem.entity.Medicine;
import LowLevelDesign.MedicineDispenseSystem.entity.Tablet;
import LowLevelDesign.MedicineDispenseSystem.state.IdleState;
import LowLevelDesign.MedicineDispenseSystem.state.MedicineState;
import LowLevelDesign.MedicineDispenseSystem.entity.Medicine;

public class MedicineContext {

    private final Inventory inventory = new Inventory();
    private MedicineState currentVendingMachineState;
    private int balance = 0;
    private String selectedItemCode;

    public MedicineContext() {
        currentVendingMachineState = new IdleState();
    }


    public void insertCoin(Coin coin) {
        currentVendingMachineState.pay(this);
    }

    public Medicine addItem(String code, String name, int price, int quantity) {
        Medicine medicine = new Tablet("tab1", new java.util.Date(), "500", 50);
        inventory.addItem(name, medicine, quantity);
        return medicine;
    }

    public void selectItem(String code) {
        currentVendingMachineState.selectItem(code);
    }

    public void dispense() {
        currentVendingMachineState.dispense(this);
    }

    public void dispenseItem() {
        Medicine item = inventory.getItem(selectedItemCode);
        if (balance >= item.getPrice()) {
            inventory.reduceStock(selectedItemCode);
            balance -= item.getPrice();
            System.out.println("Dispensed: " + "name");
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setState(new IdleState());
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public void reset() {
        selectedItemCode = null;
        balance = 0;
    }

    public void addBalance(int value) {
        balance += value;
    }

    public Medicine getSelectedItem() {
        return inventory.getItem(selectedItemCode);
    }

    public void setSelectedItemCode(String code) {
        this.selectedItemCode = code;
    }

    public void setState(MedicineState vendingMachineState) {
        this.currentVendingMachineState = vendingMachineState;
    }

    // Getters for states and inventory
    public Inventory getInventory() { return inventory; }
    public int getBalance() { return balance; }
}
