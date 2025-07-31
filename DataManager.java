import java.io.*;
import java.util.*;

public class DataManager {
    public static void savePortfolio(User user) {
        try (PrintWriter pw = new PrintWriter("portfolio.txt")) {
            pw.println(user.getName());
            pw.println(user.getPortfolio().getBalance());
            for (Map.Entry<String, Integer> entry : user.getPortfolio().getHoldings().entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error saving portfolio: " + e.getMessage());
        }
    }

    public static void loadPortfolio(User user) {
        try (Scanner sc = new Scanner(new File("portfolio.txt"))) {
            if (!sc.hasNextLine()) return;
            sc.nextLine(); // skip name
            double balance = Double.parseDouble(sc.nextLine());
            Portfolio p = new Portfolio(balance);
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                p.getHoldings().put(parts[0], Integer.parseInt(parts[1]));
            }
            user.getPortfolio().getHoldings().putAll(p.getHoldings());
        } catch (Exception e) {
            System.out.println("No previous portfolio found. Starting fresh.");
        }
    }
}