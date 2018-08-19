package springdemo2.bean;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogAnnotation {
    // 方法名
    String methodName() default "";

    // 操作目的
    String intention() default "";
}
