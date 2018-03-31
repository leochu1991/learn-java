package creational_patterns.factory_pattern.reflective_simple_factory;

/**
 * 具体产品
 */
public class BenzCar implements Car {
    private String carName;

    public BenzCar() {
    }

    public BenzCar(String carName) {
        this.carName = carName;
    }

    @Override
    public void drive() {
        System.out.println("drive " + carName);
    }
}
