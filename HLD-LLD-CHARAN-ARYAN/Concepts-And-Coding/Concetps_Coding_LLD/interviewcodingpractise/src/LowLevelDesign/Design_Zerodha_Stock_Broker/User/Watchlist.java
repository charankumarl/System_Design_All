package LowLevelDesign.Design_Zerodha_Stock_Broker.User;

import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.MarketData;
import LowLevelDesign.Design_Zerodha_Stock_Broker.Stock.Stock;

import java.util.*;

public class Watchlist {

    List<Stock> stocks = new ArrayList<>();
    int priceChange;
    int marketDepth;

    public Watchlist(int priceChange, int marketDepth) {
        this.priceChange = priceChange;
        this.marketDepth = marketDepth;
    }

    public int getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(int priceChange) {
        this.priceChange = priceChange;
    }

    public int getMarketDepth() {
        return marketDepth;
    }

    public void setMarketDepth(int marketDepth) {
        this.marketDepth = marketDepth;
    }

    // Displays the watchlist with current prices
    public void showWatchlistWithPrices(MarketData marketData) {
        for (Stock stock : stocks) {
            Integer stockPrice = marketData.getPrice(stock);
            if (stockPrice != null) {
                System.out.println("Stock: " + stock.getStockName() + ", Price: " + stockPrice);
            } else {
                System.out.println("Stock: " + stock.getStockName() + ", Price: Not available");
            }
        }
    }
}
