package creational_patterns.factory_pattern.abstract_factory;

import org.junit.Test;

/**
 * abstract factory pattern test
 * 抽象工厂包含所有产品，工厂方法只有一种
 */
public class CarAbstractFactory {
    @Test
    public void test() {
        AbstractFactory abstractFactory = new BMWFactory();
        Car car = abstractFactory.getCar("bmw");
        car.drive();
        Tyre tyre = abstractFactory.getTyre("bmwTyre");
        tyre.run();
    }
}
