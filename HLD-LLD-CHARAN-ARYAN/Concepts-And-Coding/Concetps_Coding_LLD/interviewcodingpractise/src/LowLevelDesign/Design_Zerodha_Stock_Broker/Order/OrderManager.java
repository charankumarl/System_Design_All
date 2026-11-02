package LowLevelDesign.Design_Zerodha_Stock_Broker.Order;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.Portfolio;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.Transaction;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.User;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.UserManager;
import LowLevelDesign.Design_Zerodha_Stock_Broker.enums.TxnType;

import java.time.LocalDate;

public class OrderManager {

    OrderValidater orderValidater = new OrderValidater();
    OrderExecutioner orderExecutioner = new OrderExecutioner();
    UserManager userManager = new UserManager();

    public void placeOrder(Order order){

        if(orderValidater.validateOrder(order)){
            orderExecutioner.placeOrder(order);
            createTransaction(order);
        }
        else{
            System.out.println("Order is not valid");
        }
    }

    private void createTransaction(Order order) {
        Transaction transaction = new Transaction(order.getStock(), order.getQuantity(),
                order.getStock().getStockPrice() * order.getQuantity(), LocalDate.now(), order.getType());

        User user = userManager.getUser(order.getUserId());
        Portfolio portfolio = user.getPortfolio();
        if(portfolio == null){
            portfolio = new Portfolio();
        }
        portfolio.addTransaction(transaction);
        user.setPortfolio(portfolio);
    }
}
