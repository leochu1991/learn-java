package creational_patterns.factory_pattern.abstract_factory;

/**
 * 具体工厂，benz工厂生产奔驰车和奔驰轮胎
 */
public class BenzFactory extends AbstractFactory {
    @Override
    Car getCar(String carName) {
        return new BenzCar(carName);
    }

    @Override
    Tyre getTyre(String tyreName) {
        return new BenzTyre(tyreName);
    }
}
