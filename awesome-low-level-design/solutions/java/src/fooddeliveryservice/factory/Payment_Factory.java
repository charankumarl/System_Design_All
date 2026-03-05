package fooddeliveryservice.factory;

import fooddeliveryservice.strategy.PaymentStratergy;
import fooddeliveryservice.strategy.Upi_Payment;

public class Payment_Factory {

    public static PaymentStratergy getPaymentStratergy(Payment_Type payment_type) {

        if(payment_type == Payment_Type.CASH_ON_DELIVERY) {
            return new Upi_Payment();
        }
        else if(payment_type == Payment_Type.UPI) {
            return new Upi_Payment();
        }
        else {
            throw new IllegalArgumentException("unknown payment type");
        }
    }
}
