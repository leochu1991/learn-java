package creational_patterns.factory_pattern.simple_factory;

/**
 * 工厂类每增加一种车，要修改判断逻辑，违背开闭原则——对扩展开放，对修改关闭
 * Created by leochu on 2017/12/25.
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

    public static void main(String[] args) {
        CarSimpleFactory carSimpleFactory = new CarSimpleFactory();
        Car car = carSimpleFactory.getCar("bmw");
        car.drive();
    }
}
