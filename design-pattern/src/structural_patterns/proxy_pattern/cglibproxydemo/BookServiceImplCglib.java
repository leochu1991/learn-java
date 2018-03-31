package structural_patterns.proxy_pattern.cglibproxydemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理对象
 */
public class BookServiceImplCglib implements MethodInterceptor {
    // 目标对象
    private Object target;

    /**
     * 返回代理对象
     *
     * @param target
     * @return
     */
    public Object getProxy(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置target为父类对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 回调方法
     *
     * @param o           the enhanced object，增强的子类对象
     * @param method      intercepted Method
     * @param objects     argument array; primitive types are wrapped
     * @param methodProxy used to invoke super (non-intercepted method); may be called
     *                    as many times as needed (faster)
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======目标方法开始之前======");
        // Object invoke = method.invoke(target, objects); 使用invoke时传入o会产生递归，需传入target
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("======目标方法开始之后======");
        return invokeSuper;
    }
}
