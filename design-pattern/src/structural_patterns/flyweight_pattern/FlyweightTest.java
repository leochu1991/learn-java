package structural_patterns.flyweight_pattern;

import org.junit.Test;

/**
 * flyweight pattern test
 * 减少相同对象的创建或相似对象的创建(相同部分作为内部状态:具体享元创建保存;不同部分作为外部状态:客户端创建)
 * 举例: java中的String
 */
public class FlyweightTest {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};
    private static final String[] users = {"Alex", "Bob", "Calvin"};

    // 获得随机颜色，内部状态，hashmap保存
    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    // 获得随机用户，外部状态
    private static User getRandomUser() {
        return new User(users[(int) (Math.random() * users.length)]);
    }

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            Flyweight flyweight = FlyweightFactory.getFlyweight(getRandomColor());
            flyweight.draw(getRandomUser());
        }
    }
}
