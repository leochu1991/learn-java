package creational_patterns.factory_pattern.factory_method;

import org.junit.Test;

/**
 * factory method pattern test
 * 工厂类每增加一种车，要修改判断逻辑，违背开闭原则——对扩展开放，对修改关闭
 * 工厂方法模式将具体工厂变成抽象工厂，生成同一种产品的不同系列
 */
public class CarFactoryMethod {
    @Test
    public void test() {
        AbstractFactory abstractFactory1 = new BMWFactory();
        Car bmwCar = abstractFactory1.getCar("bmw");
        bmwCar.drive();

        AbstractFactory abstractFactory2 = new BenzFactory();
        Car benzCar = abstractFactory2.getCar("benz");
        benzCar.drive();
    }
}
