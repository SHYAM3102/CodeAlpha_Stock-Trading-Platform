import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        User user = new User(name, 100000); // ₹1,00,000 initial balance
        DataManager.loadPortfolio(user);
 System.out.println("\n----- STOCK TRADING PLATFORM -----");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Save Portfolio");
            System.out.println("7. Simulate Market Change");
            System.out.println("0. Exit");
        int choice;
        do {

            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.showMarket();
                    break;

                case 2:
                    System.out.print("Enter stock symbol to BUY: ");
                    String symBuy = sc.next().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int qtyBuy = sc.nextInt();
                    Stock stockBuy = market.getStock(symBuy);
                    if (stockBuy != null && user.getPortfolio().buyStock(stockBuy, qtyBuy)) {
                        System.out.println("Bought successfully.");
                    } else {
                        System.out.println("Buy failed. Insufficient funds or invalid symbol.");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock symbol to SELL: ");
                    String symSell = sc.next().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int qtySell = sc.nextInt();
                    Stock stockSell = market.getStock(symSell);
                    if (stockSell != null && user.getPortfolio().sellStock(stockSell, qtySell)) {
                        System.out.println("Sold successfully.");
                    } else {
                        System.out.println("Sell failed. Check quantity or symbol.");
                    }
                    break;

                case 4:
                    user.getPortfolio().showPortfolio(market.getStocks());
                    break;

                case 5:
                    user.getPortfolio().showTransactions();
                    break;

                case 6:
                    DataManager.savePortfolio(user);
                    System.out.println("Portfolio saved.");
                    break;

                case 7:
                    market.simulateMarketFluctuation();
                    System.out.println("Market prices updated.");
                    break;

                case 0:
                    DataManager.savePortfolio(user);
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
        sc.close();
    }
}
