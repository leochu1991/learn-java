package structural_patterns.adapter_pattern;

/**
 * 适配器类
 */
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void normalMethod() {
        adaptee.specificMethod();
    }
}
