[TOC]

### `Java` 类加载机制

> 主要包括 加载、链接、初始化、使用、卸载 等几个步骤，而链接包含 验证、准备、解析三个过程。

#### 加载

> 将字节码加载到内存，在方法区中生成数据结构（类信息、静态变量，常量等），在堆中生成类(`java.lang.Class`) 对象。

#### 链接

> + 验证
>
>   + 类文件结构检查：确保类文件符合 `jvm` 规范
>   + 语意检查：确保类文件符合 `java` 规范
>   + 字节码验证：确保字节码流能被虚拟机安全执行
>   + 二进制兼容验证：确保类间相互引用协调一致
>
> + 准备
>
>   在方法区为类变量分配内存，并设置初始值（默认值，如 `int` 为 0）
>
> + 解析
>
>   虚拟机将常量池中的符号引用（引用其他类的方法）替换为直接引用（指向方法区中该方法的内存地址的指针）

#### 初始化

> 执行类的构造器方法 `clinit()`，包括类变量的赋值（与准备阶段不同）、静态代码块的执行，若父类未初始化，需先初始化父类。
>
> ==ps== : 类初始化方法 `clinit()` 初始化类变量，实例初始化方法 `init()` 初始化实例变量。
>
> ==pps== : 实例化类的四种方法
>
> + 操作符 `new` 一个对象
> + 反射，调用 `Class` 的 `newInstance()` 方法
> + 调用任意对象的 `clone()` 方法
> + 反序列化 ，调用 `java.io.ObjectInputStream()` 类的 `getObject()` 方法 

#### 主动引用与被动引用

> 主动引用：引起类的初始化方法，主要包括：
>
> + 四个指令引起初始化，不包括 `final` 修饰的静态常量，在方法区中
>   + `new`
>   + `getstatic`
>   + `setstatic`
>   + `invokestatic`
> + 调用 `java.lang.reflenct` 包中的方法，如 `Class.forName()`
> + 子类初始化时父类未初始化，先初始化父类
> + 虚拟机启动时指定执行类，初始化该类，即调用 `main()` 函数时初始化主类
>
> 被动引用：其它情况，被动引用不会引起类的初始化，主要包括：
>
> + 子类引用父类的静态变量，不会导致子类初始化
> + 数组定义引用不会初始化数组类
> + 常量（`static final` 修饰的变量) 在方法区中的常量池中，不会引起初始化

#### 实例

~~~ java
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

~~~

### `Java` 类加载器与双亲委派模型

#### 加载过程：

> + 通过类的全限定名获取类的二进制字节流
> + 将字节流的静态存储结构转化为方法区的运行时数据结构
> + 在堆中生成 `java.lang.Class` 对象，作为方法区中该类的数据访问入口

#### 类加载器分类：

> + 启动类加载器(`Bootstrap Classloader`)、根类加载器：加载 (`%JAVA_HOME%/lib`) 目录下的核心类库，如 `rt.jar`，启动类加载器不是 `java.lang.ClassLoader` 的子类，由 `c/c++` 编写，不能由程序员直接调用。
> + 扩展类加载器(`Extention ClassLoader`)：加载 (`%JAVA_HOME%/lib/ext`) 目录下的类库，程序员可直接调用。
> + 系统类加载器(`System ClassLoader`)、应用类加载器(`Application ClassLoader`)：加载 (`classpath`) 下的类库，默认类加载器，自定义类加载器需继承 `java.lang.ClassLoader` 类。

#### 双亲委派模型

> 工作原理：当一个类加载器收到类加载请求时，它首先不会自己尝试加载，而是委派给父类加载器进行加载，每个类加载器都是如此，最终所有的加载请求都会传到启动类加载器，只有当父类加载器无法加载类时（即无法在其加载目录中找到所需 `class`），子类加载器才会自己去加载。
>
> ==好处==：防止类被各加载器重复加载。

#### 源码实现

>  参考 `java.lang.ClassLoader` 类的 `loadClass()` 方法，主要步骤为：
>
> + 先检查类有没有被加载
> + 若没有被加载，则尝试调用父类加载器加载
> + 若父类加载器不存在，则调用启动类加载器加载
> + 若父类加载器加载抛出异常后，则调用自定义的 `findClass()` 方法加载

