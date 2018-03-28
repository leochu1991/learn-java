package behavioral_patterns.template_pattern;

/**
 * 具体实现类B
 */
public class ConcreteClassB extends Template {

    @Override
    public void method1() {
        System.out.println("===执行具体实现类B的method1()方法===");
    }

    @Override
    public void method2() {
        System.out.println("===执行具体实现类B的method2()方法===");
    }
}
