import java.util.*;

public class Market {
    private Map<String, Stock> stockList = new HashMap<>();

    public Market() {
        stockList.put("TCS", new Stock("TCS", "Tata Consultancy", 3450));
        stockList.put("INFY", new Stock("INFY", "Infosys", 1490));
        stockList.put("RELI", new Stock("RELI", "Reliance", 2480));
        stockList.put("HDFC", new Stock("HDFC", "HDFC Bank", 1670));
    }

    public Map<String, Stock> getStocks() {
        return stockList;
    }

    public void showMarket() {
        System.out.println("----- Market Prices -----");
        for (Stock s : stockList.values()) {
            System.out.println(s);
        }
    }

    public void simulateMarketFluctuation() {
        Random rand = new Random();
        for (Stock s : stockList.values()) {
            double change = (rand.nextDouble() - 0.5) * 10; // ±5%
            double newPrice = s.getPrice() * (1 + change / 100);
            s.updatePrice(Math.round(newPrice * 100.0) / 100.0);
        }
    }

    public Stock getStock(String symbol) {
        return stockList.get(symbol.toUpperCase());
    }
}