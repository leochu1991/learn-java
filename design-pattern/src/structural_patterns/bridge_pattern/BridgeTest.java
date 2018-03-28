package structural_patterns.bridge_pattern;

import org.junit.Test;

/**
 * bridge pattern test
 * 抽象部分与实现部分分离，独立变化(实现部分作为抽象部分成员变量独立变化)
 * 举例: 使用聚合而不是组合
 */
public class BridgeTest {
    @Test
    public void test() {
        Abstraction oneAbstraction = new OneAbstractionImpl();
        oneAbstraction.setImplementor(new OneImplementor());
        oneAbstraction.operation();

        oneAbstraction.setImplementor(new TwoImplementor());
        oneAbstraction.operation();
    }
}
