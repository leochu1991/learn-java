package creational_patterns.factory_pattern.abstract_factory;

/**
 * 抽象工厂测试类
 */
public class CarAbstractFactory {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new BMWFactory();
        Car car = abstractFactory.getCar("bmw");
        car.drive();
        Tyre tyre = abstractFactory.getTyre("bmwTyre");
        tyre.run();
    }
}
