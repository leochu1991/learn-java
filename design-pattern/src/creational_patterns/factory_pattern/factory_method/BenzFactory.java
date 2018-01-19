package creational_patterns.factory_pattern.factory_method;

/**
 * 具体工厂
 * Created by leochu on 2017/12/25.
 */
public class BenzFactory extends AbstractFactory {
    @Override
    BenzCar getCar(String carName) {
        return new BenzCar(carName);
    }
}
