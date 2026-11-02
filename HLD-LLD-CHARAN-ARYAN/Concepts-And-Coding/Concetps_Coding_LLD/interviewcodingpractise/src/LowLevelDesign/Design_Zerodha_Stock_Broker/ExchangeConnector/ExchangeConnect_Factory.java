package LowLevelDesign.Design_Zerodha_Stock_Broker.ExchangeConnector;

import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.ExchangeValue;

public class ExchangeConnect_Factory {

    public static ExchangeConnector getExchangeConnector(ExchangeValue type){

        if(type == ExchangeValue.NSE){
            return NSE_Exchange.getInstance();
        }
        else if(type == ExchangeValue.BSE){
            return BSE_Exchange.getInstance();
        }
        else{
            return null;
        }
    }
}
