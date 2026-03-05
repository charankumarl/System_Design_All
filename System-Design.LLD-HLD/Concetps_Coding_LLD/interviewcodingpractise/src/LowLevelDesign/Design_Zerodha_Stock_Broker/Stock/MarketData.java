package LowLevelDesign.Design_Zerodha_Stock_Broker.Stock;

import java.time.LocalDateTime;
import java.util.*;

public class MarketData {

    private Map<Stock, Integer> stockPrices = new HashMap<>();  // Stock -> Price data
    private LocalDateTime lastUpdated;  // Timestamp of the last price update

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getPrice(Stock stock) {
        return stockPrices.getOrDefault(stock, 0);
    }
}
