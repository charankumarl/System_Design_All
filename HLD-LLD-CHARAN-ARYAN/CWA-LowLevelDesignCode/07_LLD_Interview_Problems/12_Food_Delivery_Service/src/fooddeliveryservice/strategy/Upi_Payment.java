package fooddeliveryservice.strategy;

public class Upi_Payment implements PaymentStratergy{
    @Override
    public boolean MakePayment(double amount) {
        System.out.println("Payment of "+amount+" made using UPI");
        return true;
    }
}
