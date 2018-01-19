package creational_patterns.singleton_pattern;

/**
 * 枚举
 * 优点：线程安全，直接Singleton4.SINGLETON获得
 * 缺点：没有懒加载
 * 本质：
    public class Singleton4 extends Enum<Singleton4> {
    // 公有静态实例
    public static final Singleton4 SINGLETON = new Singleton4();
    }
 */
public enum Singleton4 {
    SINGLETON
}
