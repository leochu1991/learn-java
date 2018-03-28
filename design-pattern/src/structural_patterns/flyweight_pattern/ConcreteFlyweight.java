package structural_patterns.flyweight_pattern;

/**
 * 具体享元，存储内部状态，即相同部分
 */
public class ConcreteFlyweight implements Flyweight {
    private String colorName;

    public ConcreteFlyweight(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public void draw(User user) {
        System.out.println(String.format("=== %s 调用具体享元: %s 的draw()方法===", user.getUsername(), colorName));
    }
}
