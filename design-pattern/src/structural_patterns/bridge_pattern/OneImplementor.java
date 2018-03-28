package structural_patterns.bridge_pattern;

/**
 * 一个具体实现
 */
public class OneImplementor implements Implementor {
    @Override
    public void operation() {
        System.out.println("===这是OneImplementor的operation()方法===");
    }
}
