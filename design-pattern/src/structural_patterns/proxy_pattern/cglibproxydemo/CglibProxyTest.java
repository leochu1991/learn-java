package structural_patterns.proxy_pattern.cglibproxydemo;

import org.junit.Test;

/**
 * cglib测试类，针对没有实现接口的类，通过生成目标类的子类，实现方法增强，
 * 采用继承的方式，不能对final修饰的类方法代理
 */
public class CglibProxyTest {
    @Test
    public void test() {
        // 目标对象
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        BookServiceImplCglib bookServiceImplCglib = new BookServiceImplCglib();
        // 代理对象
        BookServiceImpl proxy = (BookServiceImpl) bookServiceImplCglib.getProxy(bookServiceImpl);
        proxy.addBook();
    }
}
