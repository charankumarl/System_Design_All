package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o3_State;

public class Main {

    public static void main(String[] args) {

        Vending_Machine vendingMachine = new Vending_Machine();
        vendingMachine.insertCoin();
        vendingMachine.dispenseItem();

        Vending_Machine vendingMachine1 = new Vending_Machine();
        vendingMachine1.dispenseItem();
    }
}
