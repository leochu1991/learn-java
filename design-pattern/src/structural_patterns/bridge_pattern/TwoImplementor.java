package structural_patterns.bridge_pattern;

/**
 * 另一个具体实现
 */
public class TwoImplementor implements Implementor {
    @Override
    public void operation() {
        System.out.println("===这是TwoImplementor的operation()方法===");
    }
}
