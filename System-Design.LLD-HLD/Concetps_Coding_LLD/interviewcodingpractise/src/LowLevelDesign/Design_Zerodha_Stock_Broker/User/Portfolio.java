package LowLevelDesign.Design_Zerodha_Stock_Broker.User;

import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.TxnType;

import java.util.*;

public class Portfolio {

    List<Transaction> boughtStocks = new ArrayList<>();
    List<Transaction> soldStocks = new ArrayList<>(); // Qty, Stock

    double profitPerDay;
    double profitPerMonth;

    double lossPerDay;
    double lossPerMonth;

    int totalSharesBought;

    public static final Portfolio instance = null;

    public Portfolio() {
        // Private constructor to prevent instantiation
    }

    public void addTransaction(Transaction transaction) {
        if (transaction.getOrderType() == TxnType.BUY) {
            boughtStocks.add(transaction);
            totalSharesBought += transaction.getQuantity();
        } else if (transaction.getOrderType() == TxnType.SELL) {
            soldStocks.add(transaction);
        }
    }

    public List<List<Transaction>> getTransactions() {
        List<List<Transaction>> transactions = new ArrayList<>();
        transactions.add(boughtStocks);
        transactions.add(soldStocks);
        return transactions;
    }
}
