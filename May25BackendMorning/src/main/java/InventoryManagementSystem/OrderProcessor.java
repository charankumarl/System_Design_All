package InventoryManagementSystem;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class OrderProcessor {
    private Queue<Order> orderQueue;

    public OrderProcessor() {
        orderQueue = new PriorityQueue<Order>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public void processOrder(){
        Order order = orderQueue.poll();
        System.out.println("Processing order: " + order.getOrderId());
    }

    public int getSize(){
        return orderQueue.size();
    }

}
