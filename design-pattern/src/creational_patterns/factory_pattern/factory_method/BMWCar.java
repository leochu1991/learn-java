package creational_patterns.factory_pattern.factory_method;

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
        System.out.println(carName + " drives");
    }
}
