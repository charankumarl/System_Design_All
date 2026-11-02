package LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Order.Order;

public class NSE_Exchange implements ExchangeConnector{

    private static NSE_Exchange instance = null;

    private NSE_Exchange(){
    }

    public static NSE_Exchange getInstance(){

        if(instance == null){

            synchronized (NSE_Exchange.class){

                if(instance == null){
                    instance = new NSE_Exchange();
                }
            }
        }

        return instance;
    }

    @Override
    public void sendOrderToExchange(Order order) {

        System.out.println("Sending order to NSE Exchange");
    }
}
