package javademo.classloader;

/**
 * 类加载过程，准备，初始化
 * 准备阶段 instance = null x = 0 y = 0
 * 初始化阶段 instance = new InitClass1()对象， x = 1 y = 1，然后 x = 10 y = 1
 * 输出 x = 10 y = 1
 */
public class InitClass1 {
    private static InitClass1 instance = new InitClass1();
    private static int x = 10;
    private static int y;

    static {
        System.out.println("执行 InitClass 静态代码块。。。");
    }

    private InitClass1() {
        x++;
        y++;
    }

    public static void main(String[] args) {
        System.out.println("执行 main 方法，new一个实例。。。");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
