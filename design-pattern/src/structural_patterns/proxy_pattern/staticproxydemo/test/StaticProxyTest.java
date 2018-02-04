package structural_patterns.proxy_pattern.staticproxydemo.test;

import org.junit.Test;
import structural_patterns.proxy_pattern.staticproxydemo.src.ProxySubject;
import structural_patterns.proxy_pattern.staticproxydemo.src.RealSubject;

/**
 * 优点：委托类只需关注业务逻辑本身
 * 缺点：代理类只能代理一种对象；主题接口新增一种方法，所有代理类都需要实现
 * Created by leochu on 2017/10/19.
 */
public class StaticProxyTest {
    @Test
    public void staticProxyTest1() {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.doSomething("proxy task");
    }
}
