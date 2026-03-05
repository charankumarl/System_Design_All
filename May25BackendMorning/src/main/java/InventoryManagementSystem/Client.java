package InventoryManagementSystem;

import InheritanceAndConstructors.A;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();

        items.add(new Electronics("E1", "Laptop", 5 , 999.99, 24));
        items.add(new Clothing("C1", "T-Shirt", 100 ,19.99, "M"));
        items.add(new Book("B1", "Java Programming", 50, 59.99, "John Doe"));
        System.out.println("Items List : ");
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
        System.out.println("********************************");
        // sort this list
        // Custom classes don't have any sorting order until you define it
        // default sorting order to a class : Comparable
        Collections.sort(items);
        System.out.println("Sorted Items List : ");
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        System.out.println("******************************");
        System.out.println("Electronics Inventory");
        Inventory<Electronics> electronicsInventory = new Inventory<>();
        electronicsInventory.add(new Electronics("E1", "Laptop",5 ,  999.99 , 24));
        electronicsInventory.add(new Electronics("E2", "Laptop",5 ,  999.99 , 24));
        electronicsInventory.add(new Electronics("E3", "Mobile",5, 99.99, 24));

        System.out.println("Items List from the Inventory : ");
        for (Item item : electronicsInventory.getAllItems()) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        Inventory<Book> booksInventory = new Inventory<>();
        Inventory<Clothing> clothingsInventory = new Inventory<>();
        Inventory<Item> itemsInventory = new Inventory<>();

        System.out.println("****************************");

        Item item2 = new Electronics("E2", "Mobile", 5 , 999.99, 24);
        Item item3 = new Electronics("E3", "Watch", 5 , 999.99, 24);
        Item item4 = new Electronics("E4", "Ipad", 5 , 999.99, 24);
        Item item5 = new Electronics("E5", "Speaker", 5 , 999.99, 24);
        Item item6 = new Book("B1", "Java Programming", 50, 59.99, "John Doe");
        Item item7 = new Book("B2", "Java Programming 2", 50, 59.99, "John Doe");
        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();

        recentlyViewedItems.addRecentlyViewedItem(item3);
        recentlyViewedItems.addRecentlyViewedItem(item2);
        recentlyViewedItems.addRecentlyViewedItem(item5);
        recentlyViewedItems.addRecentlyViewedItem(item2);
        recentlyViewedItems.addRecentlyViewedItem(item5);
        recentlyViewedItems.addRecentlyViewedItem(item4);
        recentlyViewedItems.addRecentlyViewedItem(item6);
        recentlyViewedItems.addRecentlyViewedItem(item7);

        System.out.println("RecentlyViewedItems List : ");
        List<Item> recentlyViewedItemsList = recentlyViewedItems.getRecentlyViewedItems();
        for (Item item : recentlyViewedItemsList) {
            System.out.println(item.getName());
        }

        System.out.println("***********************");
        System.out.println("Comparator Sorting : Desc order of quantity");
        Collections.sort(items); // default sorting
        Collections.sort(items , new ItemQuantityComparator());
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getQuantity());
        }

        System.out.println("*****************************");
        Order order1 = new Order(true, "1");
        Order order2 = new Order(false, "2");
        Order order3 = new Order(false, "3");
        Order order4 = new Order(true, "4");
        Order order5 = new Order(true, "5");

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);
        orderProcessor.addOrder(order4);
        orderProcessor.addOrder(order5);

        while(orderProcessor.getSize() > 0){
            orderProcessor.processOrder();
        }
    }
}


// Order processing
// Order : isExpress
    // true : express, process the order with smaller orderID
    // false : normal

// Queue ? : PQ

// Order : id, isExpress
// OrderProcessor : addOrder (order) , processOrder() : remove from queue