package javademo.classloader;

/**
 * 显示系统类加载器，扩展类加载器，启动类加载器
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        // 系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader applicationClassLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(String.format("系统类加载器：%s\n应用类加载器：%s", systemClassLoader.getClass().getName(), applicationClassLoader.getClass().getName()));
        // 扩展类加载器，系统类加载器的父类
        ClassLoader extentionClassLoader = systemClassLoader.getParent();
        String extDirs = System.getProperty("java.ext.dirs");
        System.out.println(String.format("扩展类加载器：%s\n扩展类加载器目录：%s", extentionClassLoader.getClass().getName(), extDirs));
        // 启动类加载器
        System.out.println(String.format("启动类加载器：%s", extentionClassLoader.getParent()));
    }
}
