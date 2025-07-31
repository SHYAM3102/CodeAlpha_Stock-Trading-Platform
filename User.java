public class User {
    private String name;
    private Portfolio portfolio;

    public User(String name, double initialBalance) {
        this.name = name;
        this.portfolio = new Portfolio(initialBalance);
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public String getName() {
        return name;
    }
}