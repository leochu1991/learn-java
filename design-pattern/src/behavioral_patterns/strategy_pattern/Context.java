package behavioral_patterns.strategy_pattern;

/**
 * 上下文类，管理策略
 */
public class Context {
    private Strategy strategy;

    public void setContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void operation(int num1, int num2) {
        strategy.operation(num1, num2);
    }
}
