package InventoryManagementSystem;

public class Order implements Comparable<Order> {
    private String orderId;
    private boolean isExpress;

    public Order(boolean isExpress, String orderId) {
        this.isExpress = isExpress;
        this.orderId = orderId;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public int compareTo(Order o) {
        if(this.isExpress) {
            return -1;
        } else if(o.isExpress) {
            return 1;
        }
        return 0;
    }
}
