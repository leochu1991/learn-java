package creational_patterns.factory_pattern.abstract_factory;

/**
 * 具体产品
 */
public class BMWTyre implements Tyre {
    private String tyreName;

    public BMWTyre(String tyreName) {
        this.tyreName = tyreName;
    }

    @Override
    public void run() {
        System.out.println(tyreName + " is running");
    }
}
