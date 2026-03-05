package LowLevelDesign.Design_Payment_Gateway;

public class Processor {

    public void processPayment(int amount, int senderId, int receiverId) {

        // Logic to process payment
        System.out.println("Processing payment of " + amount + " from user " + senderId + " to user " + receiverId);

        // Assuming payment is successful
        System.out.println("Payment successful!");
    }
}
