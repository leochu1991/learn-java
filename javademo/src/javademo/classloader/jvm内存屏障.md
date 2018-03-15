#### `volatile` 作用
+ 保持内存可见性：所有线程能看到共享内存的最新状态
  + 读取变量前会从主内存中获取最新值
  + 在工作内存中写入变量后会刷新回主内存
+ 防止指令重排
  + 设置内存屏障
  + 程序顺序规则：程序中代码A在代码B之前执行，线程中代码A也将在代码B之前执行，指令重排指的是 `jvm`指令（字节码）顺序重排

#### 举个栗子

+ 懒加载-单例模式

~~~ java
class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) { //#1 存在线程竞争
            instance = new Singleton();    //#2 存在指令重排
            }
        }
        return instance;
    }
}
~~~



+ `DCL(Double Check Lock)` + `volatile`

~~~ java
class Singleton {
    //#1 volatile防止指令重排，使变量读写具有原子性
    private static volatile Singleton instance = null;
    //#2 添加字段后存在部分初始化，需要加 volatile
    public int a = 1;
    public int b = 2;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {    //#3 加锁
                if (instance == null) {
                    instance = new Singleton();    //#4 不存在指令重排
                }
            }
        }
        return instance;
    }
}
~~~

- 指令重排

`instance = new Singleton();` 存在指令重排，其 `jvm` 指令为：

```java
memory = allocate();	//#1：分配对象的内存空间
initInstance(memory);	//#2：初始化对象（对a、b初始化）
instance = memory;		//#3：设置instance指向刚分配的内存地址
```

指令“优化”后可能变成：

~~~ java
memory = allocate();	//#1：分配对象的内存空间
instance = memory;		//#3：设置instance指向刚分配的内存地址
initInstance(memory);	//#2：初始化对象（对a、b初始化）
~~~

根据 `happens-before` 原则指令2在在指令1之后执行，但指令2，3可能执行顺序改变，`instance` 不为 `null`，但并未对 `a`，`b` 初始化，造成部分初始化

#### 参考文章

+ [volatile关键字的作用、原理](https://monkeysayhi.github.io/2016/11/29/volatile%E5%85%B3%E9%94%AE%E5%AD%97%E7%9A%84%E4%BD%9C%E7%94%A8%E3%80%81%E5%8E%9F%E7%90%86/)