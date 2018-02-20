package creational_patterns.factory_pattern.factory_method;

/**
 * Created by leochu on 2017/12/25.
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
