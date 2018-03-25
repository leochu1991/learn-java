package structural_patterns.decorator_pattern;

/**
 * 装饰类
 */
public class Decorator implements Component {
    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation(String name) {
        component.operation(name);
    }

}
