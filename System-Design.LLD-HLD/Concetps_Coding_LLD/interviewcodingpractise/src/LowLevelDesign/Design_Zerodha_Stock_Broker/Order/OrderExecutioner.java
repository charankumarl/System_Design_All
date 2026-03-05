package LowLevelDesign.Design_Zerodha_Stock_Broker.Order;

import LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector.ExchangeConnect_Factory;
import LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector.ExchangeConnector;

public class OrderExecutioner {

    ExchangeConnector exchangeConnector;

    public void placeOrder(Order order){

        exchangeConnector = ExchangeConnect_Factory.
                getExchangeConnector(order.getExchangeValue());

        exchangeConnector.sendOrderToExchange(order);
    }
}
