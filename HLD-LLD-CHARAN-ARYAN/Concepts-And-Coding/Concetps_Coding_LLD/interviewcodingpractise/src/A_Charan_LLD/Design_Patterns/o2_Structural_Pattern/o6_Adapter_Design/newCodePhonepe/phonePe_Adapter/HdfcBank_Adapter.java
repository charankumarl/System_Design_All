package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.bankApis.HdfcBank;

public class HdfcBank_Adapter implements Bank_Apis_Adapter{

    private HdfcBank hdfcBank = new HdfcBank();

    @Override
    public void pay(int amount) {
        hdfcBank.pauHdfc(amount);
    }

    @Override
    public int getBalance() {
        return hdfcBank.getBanalaceHdfc();
    }


    /**
     * We will have adapter for each bank api we have.
     *
     * 1. It will call direvtly the bank api methods.
     * 2. It will implement our own interface methods.
     */
}
