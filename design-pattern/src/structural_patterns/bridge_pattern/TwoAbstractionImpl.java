package structural_patterns.bridge_pattern;

/**
 * 另一种抽象实现类
 */
public class TwoAbstractionImpl extends Abstraction {
    private Implementor implementor;

    @Override
    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public void operation() {
        System.out.println("===这是TwoAbstractionImpl的operation()方法===");
        implementor.operation();
    }
}
