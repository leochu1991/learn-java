package creational_patterns.singleton_pattern;

/**
 * Holder模式：增加静态内部类，饿汉静态final变量 + 饱汉懒加载
 * 优点：线程安全
 */
public class Singleton3 {
    // 静态私有类
    private static class SingletonHolder {
        // final实例，唯一性
        private static final Singleton3 instance = new Singleton3();

        private SingletonHolder() {
        }
    }

    // 构造函数私有
    private Singleton3() {
    }

    // 公有静态获取实例方法，直接返回
    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}
