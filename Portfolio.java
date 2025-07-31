import java.util.*;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean buyStock(Stock stock, int qty) {
        double cost = stock.getPrice() * qty;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + qty);
            transactions.add(new Transaction(stock.getSymbol(), qty, stock.getPrice(), "BUY"));
            return true;
        }
        return false;
    }

    public boolean sellStock(Stock stock, int qty) {
        int owned = holdings.getOrDefault(stock.getSymbol(), 0);
        if (owned >= qty) {
            holdings.put(stock.getSymbol(), owned - qty);
            balance += stock.getPrice() * qty;
            transactions.add(new Transaction(stock.getSymbol(), qty, stock.getPrice(), "SELL"));
            return true;
        }
        return false;
    }

    public void showPortfolio(Map<String, Stock> market) {
        System.out.println("----- Portfolio -----");
        holdings.forEach((symbol, qty) -> {
            Stock stock = market.get(symbol);
            System.out.println(symbol + " | Qty: " + qty + " | Current Price: ₹" + stock.getPrice() + 
                " | Value: ₹" + (qty * stock.getPrice()));
        });
        System.out.println("Cash Balance: ₹" + String.format("%.2f", balance));
    }

    public void showTransactions() {
        System.out.println("----- Transaction History -----");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}