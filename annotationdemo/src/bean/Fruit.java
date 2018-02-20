package bean;

import java.lang.annotation.*;

/**
 * 水果自定义注解
 * Created by leochu on 2018/1/15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
public @interface Fruit {
    // 水果名称
    String fruitName() default "Apple";
    // 水果产地
    String fruitLocality() default "Xin Jiang";
}
