package behavioral_patterns.strategy_pattern;

import org.junit.Test;

/**
 * strategy pattern test
 * 定义一系列算法，封装起来并由context管理
 * 举例:加减乘除
 */
public class StrategyTest {
    @Test
    public void test() {
        Context context = new Context();

        Strategy addStrategy = new AddStrategy();
        context.setContext(addStrategy);
        context.operation(1, 2);

        Strategy subStrategy = new SubstractStrategy();
        context.setContext(subStrategy);
        context.operation(1, 2);

        Strategy multiplyStrategy = new MultiplyStrategy();
        context.setContext(multiplyStrategy);
        context.operation(1, 2);
    }
}
