package behavioral_patterns.strategy_pattern;

/**
 * 乘法策略
 */
public class MultiplyStrategy implements Strategy {
    @Override
    public void operation(int num1, int num2) {
        System.out.println(String.format("乘法策略: %d * %d = %d", num1, num2, num1 * num2));
    }
}
