package InventoryManagementSystem;

import java.util.Comparator;

// Desc sorted order acc to Quantity
public class ItemQuantityComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        // o1 to comes first => return -1
        // o2 to come first => return 0
        if(o1.getQuantity() < o2.getQuantity()){
            return 1;
        } else if(o1.getQuantity() > o2.getQuantity()){
            return -1;
        }
        return 0;
    }
}
