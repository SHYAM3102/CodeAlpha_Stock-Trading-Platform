import java.time.LocalDateTime;

public class Transaction {
    private String stockSymbol;
    private int quantity;
    private double price;
    private String type; // BUY or SELL
    private LocalDateTime time;

    public Transaction(String stockSymbol, int quantity, double price, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return type + " " + quantity + " of " + stockSymbol + " at ₹" + price + " on " + time;
    }
}