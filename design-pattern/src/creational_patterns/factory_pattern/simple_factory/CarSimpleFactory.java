package creational_patterns.factory_pattern.simple_factory;

import org.junit.Test;

/**
 * simple factory pattern test
 * 工厂类每增加一种车，要修改判断逻辑，违背开闭原则——对扩展开放，对修改关闭
 */
public class CarSimpleFactory {
    public Car getCar(String carName) {
        switch (carName) {
            case "benz":
                return new BenzCar(carName);
            case "bmw":
                return new BMWCar(carName);
            default:
                return null;
        }
    }

    @Test
    public void test() {
        // 没有抽象工厂类
        CarSimpleFactory carSimpleFactory = new CarSimpleFactory();
        Car bmw = carSimpleFactory.getCar("bmw");
        bmw.drive();

        Car benz = carSimpleFactory.getCar("benz");
        benz.drive();
    }
}
