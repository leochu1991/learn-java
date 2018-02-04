package springdemo2.bean;

import java.lang.annotation.*;

/**
 * Created by leochu on 2018/1/30.
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
