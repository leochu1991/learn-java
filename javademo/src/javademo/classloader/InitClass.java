package javademo.classloader;

/**
 * 类加载过程，准备，初始化
 * 输出 x = 11 y = 1
 */
public class InitClass {
    private static int x = 10;
    private static int y;

    static {
        System.out.println("执行 InitClass 静态代码块。。。");
    }

    private InitClass() {
        x++;
        y++;
    }

    public static void main(String[] args) {
        System.out.println("执行 main 方法，new一个实例。。。");
        InitClass initClass = new InitClass();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
