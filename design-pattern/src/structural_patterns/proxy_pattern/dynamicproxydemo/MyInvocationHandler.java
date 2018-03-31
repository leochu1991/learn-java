package structural_patterns.proxy_pattern.dynamicproxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义InvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler {
    // 目标类作为成员变量
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    // 获得目标对象的代理对象，根据目标对象的接口生成同名的方法
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======在目标方法执行之前======");
        // 执行目标方法
        Object result = method.invoke(target, args);
        System.out.println("======在目标方法执行之后======");

        return result;
    }
}
