package structural_patterns.proxy_pattern.staticproxydemo;

/**
 * 真实对象
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String taskName) {
        System.out.println("正在执行真实任务：" + taskName);
    }
}
