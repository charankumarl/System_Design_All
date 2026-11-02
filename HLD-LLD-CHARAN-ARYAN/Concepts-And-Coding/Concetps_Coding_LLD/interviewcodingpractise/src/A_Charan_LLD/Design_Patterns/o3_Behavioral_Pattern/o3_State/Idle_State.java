package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o3_State;

public class Idle_State implements Vending_State{

    public void insertCoin(Vending_Machine product){

        System.out.println("Coin inserted");
        product.setVendingState(new Working_State());  // State changed to Working state
    }

    public void dispenceItem(Vending_Machine product){
        System.out.println("Please insert coin");
    }
}
