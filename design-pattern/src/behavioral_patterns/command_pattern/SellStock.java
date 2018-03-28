package behavioral_patterns.command_pattern;

/**
 * 卖股票
 */
public class SellStock implements Command {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.sell();
    }
}
