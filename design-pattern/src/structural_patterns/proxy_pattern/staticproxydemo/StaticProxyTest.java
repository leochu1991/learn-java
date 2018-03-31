package structural_patterns.proxy_pattern.staticproxydemo;

import org.junit.Test;

/**
 * 静态代理测试类，代理类的字节码文件在编译期生成
 * 优点：委托类只需关注业务逻辑本身
 * 缺点：代理类只能代理一种对象；主题接口新增一种方法，所有代理类都需要实现
 */
public class StaticProxyTest {
    @Test
    public void test() {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.doSomething("proxy task");
    }
}
