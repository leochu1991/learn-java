package structural_patterns.adapter_pattern;

/**
 * 正常目标对象
 */
public class NormalTarget implements Target{
    @Override
    public void normalMethod() {
        System.out.println("===这是正常对象方法===");
    }
}
