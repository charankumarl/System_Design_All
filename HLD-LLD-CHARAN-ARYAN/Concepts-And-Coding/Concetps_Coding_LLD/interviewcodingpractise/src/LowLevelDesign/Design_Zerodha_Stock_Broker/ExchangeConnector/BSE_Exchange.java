package LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Order.Order;

public class BSE_Exchange implements ExchangeConnector{

    private static BSE_Exchange instance = null;

    private BSE_Exchange(){}

    public static BSE_Exchange getInstance(){

        if(instance == null){

            synchronized (BSE_Exchange.class){

                if(instance == null){
                    instance = new BSE_Exchange();
                }
            }
        }
        return instance;
    }

    @Override
    public void sendOrderToExchange(Order order) {

        System.out.println("Sending order to BSE Exchange");
    }
}
