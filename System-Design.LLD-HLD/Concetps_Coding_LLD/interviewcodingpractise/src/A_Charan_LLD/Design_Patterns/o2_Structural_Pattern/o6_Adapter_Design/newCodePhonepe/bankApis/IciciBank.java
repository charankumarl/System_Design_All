package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.bankApis;

public class IciciBank {

    public int getBanalaceIcici(){
        System.out.println("Icici Bank balance fetched");
        return 10000;
    }

    public void pauIcici(int amont){
        System.out.println("Payment done using Icici Bank: " + 100);
    }
}
