package structural_patterns.proxy_pattern.reflectivedemo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射测试类
 */
public class ReflectiveTest {
    @Test
    public void test() {
        try {
            // 根据全类名获得类
            Class<?> clazz = Class.forName("structural_patterns.proxy_pattern.reflectivedemo.Student");
            System.out.println(String.format("类名：%s", clazz.toString()));

            // 获取所有构造方法
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                System.out.println(String.format("构造方法：%s", constructor.toString()));
            }
            // 获取私有构造方法，并赋值
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            Object zhangsan = declaredConstructor.newInstance("张三");
            System.out.println(String.format("私有构造方法创建学生类 %s", zhangsan.toString()));
            // 获取所有成员变量
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println(String.format("成员变量：%s", field.toString()));
            }
            // 获取私有成员变量
            Field username = clazz.getDeclaredField("username");
            username.setAccessible(true);
            username.set(zhangsan, "李四");
            System.out.println(String.format("张三的新名字是：%s", zhangsan));
            // 获取所有方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(String.format("成员方法签名：%s", method.toString()));
            }
            // 获取私有方法(方法名,形参类型)
            Method isAgeOver18 = clazz.getDeclaredMethod("isAgeOver18", int.class);
            isAgeOver18.setAccessible(true);
            // 输入调用对象，形参，返回结果
            boolean result = (boolean) isAgeOver18.invoke(zhangsan, 20);
            System.out.println(String.format("张三是否大于18？%s", result ? "是" : "否"));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
