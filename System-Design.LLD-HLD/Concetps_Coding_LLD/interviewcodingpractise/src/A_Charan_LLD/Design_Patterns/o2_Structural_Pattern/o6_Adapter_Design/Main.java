package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o6_Adapter_Design;

public class Main {

    public static void main(String[] args) {

        // Creating Adaptee (Razorpay)
        RazorPay razorPay = new RazorPay();

        // Using Adapter to make Razorpay compatible with PaymentGateway
        Payment_Gateway paymentGateway = new RazorPay_Adapator(razorPay);

        // Client uses the standard interface without worrying about internal details
        paymentGateway.processPayment(1000);
    }
}
