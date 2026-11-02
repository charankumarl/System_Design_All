package LowLevelDesign.Design_Zerodha_Stock_Broker;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Order.Order;
import LowLevelDesign.Design_Zerodha_Stock_Broker.Order.OrderManager;
import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.Transaction;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.User;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.UserManager;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.ExchangeValue;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.TxnType;

import java.util.List;

public class Zerodha {

    public static void main(String[] args) {

        // create user
        User user = new User(1, "charan", 2000.0);
        User uer2 = new User(2, "kumar", 2000.0);

        // create stocks
        Stock stock1 = new Stock("Reliance", 100.0, ExchangeValue.NSE);
        Stock stock2 = new Stock("Tata", 200.0, ExchangeValue.BSE);

        UserManager userManager = new UserManager();
        userManager.addUser(user.getId(), user);
        userManager.addUser(uer2.getId(), uer2);

        Order order= new Order(stock1, 10, user.getId(), TxnType.BUY, ExchangeValue.NSE);
        Order order2= new Order(stock2, 5, user.getId(), TxnType.SELL, ExchangeValue.BSE);

        // create order for user 2
        Order order3= new Order(stock1, 10, uer2.getId(), TxnType.BUY, ExchangeValue.NSE);
        Order order4= new Order(stock2, 3, uer2.getId(), TxnType.SELL, ExchangeValue.BSE);

        OrderManager orderManager = new OrderManager();
        orderManager.placeOrder(order);
        orderManager.placeOrder(order2);

        // place order for user 2

        orderManager.placeOrder(order3);
        orderManager.placeOrder(order4);

        List<List<Transaction>> portfolio = user.getPortfolio().getTransactions();
        for (List<Transaction> transactions : portfolio) {
            for (Transaction transaction : transactions) {
                System.out.println("Stock: " + transaction.getStock().getStockName() +
                        ", Quantity: " + transaction.getQuantity() +
                        ", Price: " + transaction.getPrice() +
                        ", Type: " + transaction.getOrderType());
            }
        }

        List<List<Transaction>> portfolio1 = uer2.getPortfolio().getTransactions();
        for (List<Transaction> transactions : portfolio1) {
            for (Transaction transaction : transactions) {
                System.out.println("Stock: " + transaction.getStock().getStockName() +
                        ", Quantity: " + transaction.getQuantity() +
                        ", Price: " + transaction.getPrice() +
                        ", Type: " + transaction.getOrderType());
            }
        }
    }
}
