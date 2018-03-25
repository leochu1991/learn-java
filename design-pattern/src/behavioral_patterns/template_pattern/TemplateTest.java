package behavioral_patterns.template_pattern;

import org.junit.Test;

/**
 * template pattern test
 * 代码复用，不变的行为在父类，去掉子类的重复代码
 * 举例: java中的继承
 */
public class TemplateTest {
    @Test
    public void test() {
        Template concreteClassA = new ConcreteClassA();
        concreteClassA.templateMethod();

        ConcreteClassB concreteClassB = new ConcreteClassB();
        concreteClassB.templateMethod();
    }
}
