package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.bankApis;

public class HdfcBank {

    public int getBanalaceHdfc(){
        System.out.println("HDFC Bank balance fetched");
        return 10000;
    }

    public void pauHdfc(int amont){
        System.out.println("Payment done using HDFC Bank: " + 100);
    }

    /**
     * Ecah bank can have their own methods.
     */
}
