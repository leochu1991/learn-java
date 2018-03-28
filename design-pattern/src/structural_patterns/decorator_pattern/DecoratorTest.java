package structural_patterns.decorator_pattern;

import org.junit.Test;

/**
 * decorator pattern test
 * 给对象动态地添加新功能，不改变其结构
 * 举例: java中的io流(InputStream,BufferedInputStream etc.)
 */
public class DecoratorTest {
    @Test
    public void test() {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation("唱歌");

        Decorator decorator1 = new ConcreteDecorator(decorator);
        decorator1.operation("跳舞");
    }
}
