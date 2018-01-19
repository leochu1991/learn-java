package creational_patterns.factory_pattern.abstract_factory;

/**
 * 具体产品
 */
public class BenzTyre implements Tyre {
    private String tyreName;

    public BenzTyre(String tyreName) {
        this.tyreName = tyreName;
    }

    @Override
    public void run() {
        System.out.println(tyreName + " is running");
    }
}
