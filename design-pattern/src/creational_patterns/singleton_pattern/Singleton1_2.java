package creational_patterns.singleton_pattern;

/**
 * 饱汉模式变种2：双重检查锁（Double Check Lock，DCL）
 * 优点：懒加载 + “线程安全”
 * 缺点：线程不安全，由于指令重排，会获得“半个对象”
 */
public class Singleton1_2 {
    // 静态私有实例
    private static Singleton1_2 instance = null;

    // 构造函数私有
    private Singleton1_2() {
    }

    // 同步代码块获取实例
    public static Singleton1_2 getInstance() {
        // 可能获得半个对象，然后返回
        if (instance == null) {
            synchronized (Singleton1_2.class) {
                if (instance == null) {
                    instance = new Singleton1_2();
                }
            }
        }
        return instance;
    }
}
