import bean.Apple;
import org.junit.Test;
import service.FruitAnnotationHandler;

/**
 * 注解测试类
 */
public class FruitAnnotationTest {
    @Test
    public void test() {
        FruitAnnotationHandler.handle(Apple.class);
    }
}
