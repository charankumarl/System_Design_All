package InventoryManagementSystem;

public class Item implements Comparable<Item> {
    private String id;
    private String name;
    private int quantity;
    private double price;
//    private static int idCounter = 0;
    public Item() {
    }

    public Item(String id, String name, int quantity, double price) {
//        this.id = "Id-" + idCounter++;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int compareTo(Item other) {
        // one object : this object : return -1
        // another object : passed in arg : return 1
        // equal : return 0

        // algo : asc of price
        if(this.price > other.getPrice()) {
            return 1;
        } else if(this.price < other.getPrice()) {
            return -1;
        }
        return 0;
    }
}

// sort : ItemObject.compareTo(OtherItemObject)