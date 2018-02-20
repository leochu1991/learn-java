package structural_patterns.proxy_pattern.dynamicproxydemo.test;

import org.junit.Test;
import structural_patterns.proxy_pattern.dynamicproxydemo.src.MyInvocationHandler;
import structural_patterns.proxy_pattern.dynamicproxydemo.src.UserService;
import structural_patterns.proxy_pattern.dynamicproxydemo.src.UserServiceImpl;

/**
 * 动态代理测试类，运行期反射生成代理类；只针对实现了接口的类进行代理
 */
public class DynamicProxyTest {
    @Test
    public void test() {
        // 目标类
        UserService userServiceImpl = new UserServiceImpl();
        // 目标类作为构造参数传入，作为target
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userServiceImpl);
        // 获得目标类的代理对象
        UserService proxy = (UserService) myInvocationHandler.getProxy();
        // 执行代理类的同名方法
        proxy.add();
    }
}
