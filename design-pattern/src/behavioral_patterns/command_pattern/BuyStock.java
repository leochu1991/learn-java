package behavioral_patterns.command_pattern;

/**
 * 买股票
 */
public class BuyStock implements Command {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.buy();
    }
}
