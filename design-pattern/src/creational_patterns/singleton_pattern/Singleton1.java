package creational_patterns.singleton_pattern;

/**
 * 饱汉模式：先不初始化，第一次使用时再初始化，即“懒加载”
 * 优点：启动速度快，节省资源
 * 缺点：线程不安全，存在if的竞态条件
 */
public class Singleton1 {
    // 静态私有实例
    private static Singleton1 instance = null;

    // 构造函数私有
    private Singleton1() {
    }

    // 公有静态获取实例方法，第一次使用时加载
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
