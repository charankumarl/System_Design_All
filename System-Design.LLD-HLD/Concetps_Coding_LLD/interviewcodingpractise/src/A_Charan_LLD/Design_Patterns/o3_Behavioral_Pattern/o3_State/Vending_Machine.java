package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o3_State;

public class Vending_Machine {

    Vending_State vendingState;

    public Vending_Machine(){
        vendingState = new Idle_State();  // 1. Initial state
    }

    public void setVendingState(Vending_State vendingState) {
        this.vendingState = vendingState;
    }

    public void insertCoin() {
        vendingState.insertCoin(this);  // 2. State transition here.
    }

    public void dispenseItem() {
        vendingState.dispenceItem(this);  // 3. State transition here.
    }
}
