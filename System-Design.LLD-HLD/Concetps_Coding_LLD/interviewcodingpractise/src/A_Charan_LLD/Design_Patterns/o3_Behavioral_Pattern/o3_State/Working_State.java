package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o3_State;

public class Working_State implements Vending_State{

    public void insertCoin(Vending_Machine product){

        System.out.println("Previous product is being processed, Please wait");
    }

    public void dispenceItem(Vending_Machine product){

        System.out.println("product is dispensed. Thanks");
        product.setVendingState(new Idle_State()); // change the state to idle
    }
}
