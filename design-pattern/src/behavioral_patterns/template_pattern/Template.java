package behavioral_patterns.template_pattern;

/**
 * 模板抽象类
 */
public abstract class Template {
    // 抽象方法在具体子类实现
    public abstract void method1();

    public abstract void method2();

    // 模板方法,设置方法逻辑,实现在子类,final避免修改
    public final void templateMethod() {
        System.out.println("===开始执行模板方法templateMethod()===");
        method1();
        method2();
        System.out.println("===模板方法templateMethod()执行结束===");
    }
}
