package LowLevelDesign.Design_Zerodha_Stock_Broker.User;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.OrderType;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.TxnType;

import java.time.LocalDate;

public class Transaction {

    private Stock stock;
    private int quantity;
    private double price;
    private LocalDate date;
    private TxnType orderType;

    public Transaction(Stock stock, int quantity, double price, LocalDate date, TxnType orderType) {
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.orderType = orderType;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TxnType getOrderType() {
        return orderType;
    }

    public void setOrderType(TxnType orderType) {
        this.orderType = orderType;
    }
}
