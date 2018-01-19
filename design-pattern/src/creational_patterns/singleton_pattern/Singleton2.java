package creational_patterns.singleton_pattern;

/**
 * 饿汉模式：类加载时初始化，直接返回
 * 优点：线程安全
 * 缺点：可能存在资源浪费
 */
public class Singleton2 {
    // 静态私有final实例
    private static final Singleton2 instance = new Singleton2();

    // 构造函数私有
    private Singleton2() {
    }

    // 公有静态获取实例方法，直接返回
    public static Singleton2 getInstance() {
        return instance;
    }
}
