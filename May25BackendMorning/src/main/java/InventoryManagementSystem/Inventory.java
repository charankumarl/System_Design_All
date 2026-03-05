package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory <T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void add(T item) {
        items.put(item.getId(), item);
    }

    public void remove(T item) {
        items.remove(item.getId());
    }

    public void remove(String itemId) {
        items.remove(itemId);
    }

    public T get(String itemId) {
        return items.get(itemId);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items.values());
    }
}

// Electronics Inventory
// we want to mention the type of items during the inventory creation
