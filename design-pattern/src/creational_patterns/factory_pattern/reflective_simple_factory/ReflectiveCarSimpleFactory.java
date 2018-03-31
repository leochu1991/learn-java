package creational_patterns.factory_pattern.reflective_simple_factory;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * reflective simple factory pattern test
 * 使用反射获取具体对象
 */
public class ReflectiveCarSimpleFactory {
    @SuppressWarnings(value = {"unchecked"})
    public static <T> T getCar(Class<? extends T> clazz, String carName) {
        T object = null;
        try {
            object = (T) Class.forName(clazz.getName()).newInstance();
            Field carNameField = clazz.getDeclaredField("carName");
            carNameField.setAccessible(true);
            carNameField.set(object, carName);
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    @Test
    public void test() {
        Car bmw = ReflectiveCarSimpleFactory.getCar(BMWCar.class, "bmw");
        bmw.drive();

        Car benz = ReflectiveCarSimpleFactory.getCar(BenzCar.class, "benz");
        benz.drive();
    }
}
