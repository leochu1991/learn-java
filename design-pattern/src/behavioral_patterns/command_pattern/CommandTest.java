package behavioral_patterns.command_pattern;

import org.junit.Test;

/**
 * command pattern test
 * 请求以命令的形式封装成对象，由调用者调用，调用者包含一系列命令对象
 */
public class CommandTest {
    @Test
    public void test() {
        Broker broker = new Broker();

        Stock stock = new Stock();
        Command buyStock1 = new BuyStock(stock);
        Command buyStock2 = new BuyStock(stock);
        Command sellStock1 = new SellStock(stock);

        broker.addCommand(buyStock1);
        broker.addCommand(buyStock2);
        broker.addCommand(sellStock1);

        broker.executeAllCommand();
    }
}
