package structural_patterns.proxy_pattern.staticproxydemo;

/**
 * 代理对象
 */
public class ProxySubject implements Subject {
    //委托对象
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doSomething(String taskName) {
        System.out.println("开始执行代理任务。。。");
        delegate.doSomething(taskName);
        System.out.println("结束执行代理任务！！！");
    }
}
