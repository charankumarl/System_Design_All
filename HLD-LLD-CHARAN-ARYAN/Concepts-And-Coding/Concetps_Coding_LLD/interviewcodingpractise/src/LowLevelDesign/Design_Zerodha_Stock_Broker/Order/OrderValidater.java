package LowLevelDesign.Design_Zerodha_Stock_Broker.Order;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.User;
import LowLevelDesign.Design_Zerodha_Stock_Broker.User.UserManager;

public class OrderValidater {

    static UserManager userManager;

    public OrderValidater() {
        userManager = new UserManager();
    }

    public boolean validateOrder(Order order){

        User user = userManager.getUser(order.getUserId());
        Stock stock = order.getStock();
        double totalPrice = stock.getStockPrice() * order.getQuantity();

        if(user.getBalance() <= totalPrice){
            System.out.println("insufficient balance");
            return false;
        }

        System.out.println("Order is valid");
        return true;
    }
}
