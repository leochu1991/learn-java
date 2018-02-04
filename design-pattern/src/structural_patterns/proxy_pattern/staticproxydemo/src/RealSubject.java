package structural_patterns.proxy_pattern.staticproxydemo.src;

/**
 * 真实对象
 * Created by leochu on 2017/10/19.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String taskName) {
        System.out.println("正在执行真实任务：" + taskName);
    }
}
