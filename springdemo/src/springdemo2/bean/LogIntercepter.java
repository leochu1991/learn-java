package springdemo2.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 * Created by leochu on 2018/1/30.
 */
@Aspect
@Component
public class LogIntercepter {
    // 定义切入点
    @Pointcut(value = "execution(* springdemo2.bean.*.*(..))")
    public void logPointcut() {
    }

    @Around(value = "logPointcut() && @annotation(logAnnotation) && args(object,..)")
    public Object logHandler(ProceedingJoinPoint proceedingJoinPoint, LogAnnotation logAnnotation, Object object) throws Throwable {
        // 打印注解内容
        String methodName = logAnnotation.methodName();
        String intention = logAnnotation.intention();
        System.out.println(String.format("注解方法名：%s\n注解方法作用：%s", methodName, intention));
        // 打印连接点方法名，形参
        String name = proceedingJoinPoint.getSignature().getName();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println(String.format("连接点方法名：%s", name));
        if (parameterNames == null) {
            System.out.println("参数名为null");
        } else {
            for (int i = 0; i < parameterNames.length; i++) {
                System.out.println(String.format("%s:%s", parameterNames[i], args[i]));
            }
        }

        System.out.println("开始执行方法。。。");
        Object result = proceedingJoinPoint.proceed();
        System.out.println(String.format("方法执行完毕。。。\n返回结果：%s", result));

        return result;
    }
}
