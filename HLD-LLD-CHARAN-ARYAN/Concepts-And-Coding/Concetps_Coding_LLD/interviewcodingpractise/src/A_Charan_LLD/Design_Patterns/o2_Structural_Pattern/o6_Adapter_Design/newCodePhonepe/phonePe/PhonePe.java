package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter.Bank_Apis_Adapter;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter.HdfcBank_Adapter;

public class PhonePe {

    Bank_Apis_Adapter bank;      /// we are depending only on our adapter and it will take care of everthing

    public PhonePe(Bank_Apis_Adapter bank) {
        this.bank = bank;
    }

    public void pay(int amount){
        bank.pay(amount);
    }

    public int getBalance(){
        return bank.getBalance();
    }

    /**
     * 1. We are not changing any code in phone pe, just we will introduce the new serice via adapter.
     *
     * 2. Changes will be done only in the adapter classes.
     *
     * 3. If we dont use adapter, then we need to change the phonepe class every time we introduce a new bank api.
     */
}
