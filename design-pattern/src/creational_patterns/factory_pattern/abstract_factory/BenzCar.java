package creational_patterns.factory_pattern.abstract_factory;

/**
 * 具体产品
 */
public class BenzCar implements Car {
    private String carName;

    public BenzCar(String carName) {
        this.carName = carName;
    }

    @Override
    public void drive() {
        System.out.println(carName + " drives");
    }
}
