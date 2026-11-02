package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.bankApis.HdfcBank;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.bankApis.IciciBank;

public class IciciBank_Adapter implements Bank_Apis_Adapter{

    private IciciBank iciciBank = new IciciBank();

    @Override
    public void pay(int amount) {
        iciciBank.pauIcici(amount);
    }

    @Override
    public int getBalance() {
        return iciciBank.getBanalaceIcici();
    }
}
