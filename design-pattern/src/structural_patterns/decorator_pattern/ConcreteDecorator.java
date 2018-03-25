package structural_patterns.decorator_pattern;

/**
 * 具体装饰类
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation(String name) {
        System.out.println(String.format("===具体装饰类动作: %s===", name));
        super.operation(name);
    }
}
