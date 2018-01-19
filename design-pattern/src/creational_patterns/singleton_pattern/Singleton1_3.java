package creational_patterns.singleton_pattern;

/**
 * 饱汉模式变种3：双重检查锁（Double Check Lock，DCL） + volatile
 * 优点：懒加载 + 线程安全
 */
public class Singleton1_3 {
    // 静态私有实例
    private static volatile Singleton1_3 instance = null;

    // 构造函数私有
    private Singleton1_3() {
    }

    // 同步代码块获取实例
    public static Singleton1_3 getInstance() {
        if (instance == null) {
            synchronized (Singleton1_3.class) {
                // 必须是完整实例
                if (instance == null) {
                    instance = new Singleton1_3();
                }
            }
        }
        return instance;
    }
}
