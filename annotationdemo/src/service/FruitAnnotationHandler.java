package service;

import bean.Fruit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 水果注解处理器
 */
public class FruitAnnotationHandler {
    public static <T> void handle(Class<T> clazz) {
        // 获取字段和方法
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getMethods();
        // 打印输出自定义注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(Fruit.class)) {
                Fruit fieldAnnotation = field.getAnnotation(Fruit.class);
                System.out.println("field annotation is present on field : " + field.getName()
                        + ", name is " + fieldAnnotation.fruitName()
                        + ", locality is " + fieldAnnotation.fruitLocality());
            }
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(Fruit.class)) {
                Fruit methodAnnotation = method.getAnnotation(Fruit.class);
                System.out.println("method annotation is present on method : " + method.getName()
                        + ", name is " + methodAnnotation.fruitName()
                        + ", locality is " + methodAnnotation.fruitLocality());
            }
        }
    }
}
