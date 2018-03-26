package structural_patterns.bridge_pattern;

/**
 * 抽象部分,包含实现部分的成员变量
 */
public abstract class Abstraction {
    private Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
