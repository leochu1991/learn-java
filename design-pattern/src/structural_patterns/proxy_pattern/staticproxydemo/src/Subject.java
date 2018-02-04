package structural_patterns.proxy_pattern.staticproxydemo.src;

/**
 * 主题接口
 * Created by leochu on 2017/10/19.
 */
public interface Subject {
    /**
     * 执行任务taskName
     *
     * @param taskName
     */
    void doSomething(String taskName);
}
