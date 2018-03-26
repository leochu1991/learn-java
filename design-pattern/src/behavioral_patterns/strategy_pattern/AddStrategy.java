package behavioral_patterns.strategy_pattern;

/**
 * 加法策略
 */
public class AddStrategy implements Strategy {
    @Override
    public void operation(int num1, int num2) {
        System.out.println(String.format("加法策略: %d + %d = %d", num1, num2, num1 + num2));
    }
}
