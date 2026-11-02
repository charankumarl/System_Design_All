package LowLevelDesign.Design_Zerodha_Stock_Broker.Stock;

import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.ExchangeValue;

public class Stock {

    private String stockName;
    private double stockPrice;
    ExchangeValue exchange;     // NSE / BSE

    public Stock(String stockName, double stockPrice, ExchangeValue exchange) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.exchange = exchange;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public ExchangeValue getExchange() {
        return exchange;
    }

    public void setExchange(ExchangeValue exchange) {
        this.exchange = exchange;
    }
}
