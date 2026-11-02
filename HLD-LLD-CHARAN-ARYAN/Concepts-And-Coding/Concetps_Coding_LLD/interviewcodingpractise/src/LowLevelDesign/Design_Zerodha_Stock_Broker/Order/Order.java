package LowLevelDesign.Design_Zerodha_Stock_Broker.Order;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.User;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.ExchangeValue;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.TxnType;

public class Order {

    Stock stock;
    int quantity;
    int userId;
    TxnType type;
    ExchangeValue exchangeValue;

    public Order(Stock stock, int quantity, int userId, TxnType type, ExchangeValue exchangeValue) {
        this.stock = stock;
        this.quantity = quantity;
        this.userId = userId;
        this.type = type;
        this.exchangeValue = exchangeValue;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TxnType getType() {
        return type;
    }

    public void setType(TxnType type) {
        this.type = type;
    }

    public ExchangeValue getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(ExchangeValue exchangeValue) {
        this.exchangeValue = exchangeValue;
    }
}
