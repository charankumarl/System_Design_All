package LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Order.Order;

public interface ExchangeConnector {

    void sendOrderToExchange(Order order);
}
