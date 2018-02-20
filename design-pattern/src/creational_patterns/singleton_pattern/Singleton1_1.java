package creational_patterns.singleton_pattern;

/**
 * 饱汉模式变种1：使用synchronized修饰getInstance方法
 * 优点：线程安全
 * 缺点：并发性差
 */
public class Singleton1_1 {
    // 静态私有实例
    private static Singleton1_1 instance = null;

    // 构造函数私有
    private Singleton1_1() {
    }

    // 同步方法获取实例
    public static synchronized Singleton1_1 getInstance() {
        if (instance == null) {
            instance = new Singleton1_1();
        }
        return instance;
    }
}
