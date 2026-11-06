package fooddeliveryservice.strategy;

import onlineshoppingservice.strategy.PaymentStrategy;

public class Cach_On_Delivery_Payment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}
