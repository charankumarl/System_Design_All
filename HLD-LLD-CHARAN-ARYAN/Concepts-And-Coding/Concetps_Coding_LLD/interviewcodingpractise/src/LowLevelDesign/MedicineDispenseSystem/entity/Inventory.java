package LowLevelDesign.MedicineDispenseSystem.entity;

import LowLevelDesign.MedicineDispenseSystem.state.MedicineState;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Medicine> itemMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();

    public void addItem(String code, Medicine item, int quantity) {
        itemMap.put(code, item);
        stockMap.put(code, quantity);
    }

    public Medicine getItem(String code) {
        return itemMap.get(code);
    }

    public boolean isAvailable(String code) {
        return stockMap.getOrDefault(code, 0) > 0;
    }

    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code) - 1);
    }
}
