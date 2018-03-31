package creational_patterns.factory_pattern.reflective_simple_factory;

/**
 * 具体产品
 */
public class BMWCar implements Car {
    private String carName;

    public BMWCar() {
    }

    public BMWCar(String carName) {
        this.carName = carName;
    }

    @Override
    public void drive() {
        System.out.println("drive " + carName);
    }
}
