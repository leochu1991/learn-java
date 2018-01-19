import bean.Apple;
import org.junit.Test;
import service.FruitAnnotationHandler;

/**
 * Created by leochu on 2018/1/16.
 */
public class FruitAnnotationTest {
    @Test
    public void test1(){
        FruitAnnotationHandler.handle(Apple.class);
    }
}
