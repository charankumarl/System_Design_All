package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe.PhonePe;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter.HdfcBank_Adapter;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design.newCodePhonepe.phonePe_Adapter.IciciBank_Adapter;

public class Main {

    public static void main(String[] args) {

        PhonePe phonePe = new PhonePe(new HdfcBank_Adapter());

        ///  Currently phonepe is using HDFC Bank Adapter to all service

        phonePe.pay(100);
        phonePe.getBalance();

        ///  Now we will change to ICICI bank, but we are not changing any code in PhonePe class
        ///  This is the power of Adapter Design Pattern

        phonePe = new PhonePe(new IciciBank_Adapter());

        phonePe.pay(100);
        phonePe.getBalance();
    }
}
