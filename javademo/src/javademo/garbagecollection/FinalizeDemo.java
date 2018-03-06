package javademo.garbagecollection;

import java.util.concurrent.TimeUnit;

/**
 * 对象回收-二次标记
 */
public class FinalizeDemo {
    private static FinalizeDemo instance = null;

    private void isAlive() {
        System.out.println("yes,i am alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() method has been executed.");
        // 将待回收对象与引用链上对象（类变量）关联
        FinalizeDemo.instance = this;
    }

    public static void main(String[] args) {
        instance = new FinalizeDemo();
        // 取消引用
        instance = null;
        // 垃圾回收，instance对象执行finalize()方法
        System.gc();
        // 休眠让出cpu，让回收线程执行
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 判断对象存活
        if (instance != null) {
            instance.isAlive();
        } else {
            System.out.println("no,i am dead!");
        }
        // 再次取消引用
        instance = null;
        // 再次垃圾回收，instance不会执行finalize()方法，任何对象的finalize()方法只执行一次
        System.gc();
        // 再次判断对象存活
        if (instance != null) {
            instance.isAlive();
        } else {
            System.out.println("no,i am dead!");
        }
    }
}
