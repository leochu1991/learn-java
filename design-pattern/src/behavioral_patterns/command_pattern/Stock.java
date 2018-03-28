package behavioral_patterns.command_pattern;

import java.util.Date;

/**
 * 股票类，包含各种命令
 */
public class Stock {
    public void sell() {
        System.out.println(String.format("===command: sell stock, date: %tc===", new Date()));
    }

    public void buy() {
        System.out.println(String.format("===command: buy stock, date: %tc===", new Date()));
    }
}
