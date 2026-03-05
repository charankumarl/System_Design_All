package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design;

public class RazorPay_Adapator implements Payment_Gateway{

    // Adapter: Converts Razorpay interface to PaymentGateway interface
    private RazorPay razorPay;

    public RazorPay_Adapator(RazorPay razorPay){
        this.razorPay = razorPay;
    }

    public void processPayment(int amount){

        System.out.println("Adapter converting request...");
        razorPay.pay(amount);
    }
}
