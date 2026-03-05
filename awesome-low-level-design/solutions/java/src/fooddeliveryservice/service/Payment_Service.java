package fooddeliveryservice.service;

import fooddeliveryservice.factory.Payment_Factory;
import fooddeliveryservice.factory.Payment_Type;
import fooddeliveryservice.strategy.PaymentStratergy;

public class Payment_Service {

    PaymentStratergy paymentStratergy;

    public boolean makePayment(double amount, Payment_Type payment_type) {

        this.paymentStratergy = Payment_Factory.getPaymentStratergy(payment_type);

        return paymentStratergy.MakePayment(amount);
    }
}
