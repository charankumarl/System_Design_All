package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design;

public class RazorPay {

    // Adaptee: Existing Payment Gateway (Razorpay)
    public void pay(int amount){
        System.out.println("Payment done by RazorPay: " + amount);
    }
}
