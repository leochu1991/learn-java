package creational_patterns.factory_pattern.abstract_factory;

/**
 * 具体工厂，bmw工厂生产宝马车和宝马轮胎
 */
public class BMWFactory extends AbstractFactory {
    @Override
    Car getCar(String carName) {
        return new BMWCar(carName);
    }

    @Override
    Tyre getTyre(String tyreName) {
        return new BMWTyre(tyreName);
    }
}
