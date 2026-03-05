package InventoryManagementSystem;

import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems {
    private LinkedList<Item> recentlyViewedItems;
    private Integer MAX_SIZE;
    public RecentlyViewedItems() {
        recentlyViewedItems = new LinkedList<>();
        MAX_SIZE = 5;
    }

    public void addRecentlyViewedItem(Item item) {
        recentlyViewedItems.remove(item);
        recentlyViewedItems.add(item);

        if(recentlyViewedItems.size() > MAX_SIZE) {
            recentlyViewedItems.removeFirst();
        }
    }

    public List<Item> getRecentlyViewedItems() {
        return recentlyViewedItems;
    }

}
