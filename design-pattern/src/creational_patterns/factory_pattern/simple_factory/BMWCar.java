package creational_patterns.factory_pattern.simple_factory;

/**
 * 具体产品
 */
public class BMWCar implements Car {
    private String carName;

    public BMWCar(String carName) {
        this.carName = carName;
    }

    @Override
    public void drive() {
        System.out.println("drive " + carName);
    }
}
