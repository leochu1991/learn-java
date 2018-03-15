package demo.demo4;

/**
 * 功能：B线程在A线程输出1,2之后输出数字1,2,3,4,5，然后线程A再输出3,4,5(在线程A中使用object.wait(),object.notify())
 */
public class Demo4 {
    public static void main(String[] args) {
        // 线程A和B的共享锁
        final Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 2; i++) {
                        System.out.println("===========线程A输出数字" + (i + 1) + "============");
                        printNum(Thread.currentThread().getName(), i + 1);
                    }
                    try {
                        System.out.println("===========线程A等待线程B输出数字==========");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 2; i < 5; i++) {
                        System.out.println("===========线程A继续输出数字" + (i + 1) + "============");
                        printNum(Thread.currentThread().getName(), i + 1);
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("===========线程B开始输出数字1,2,3,4,5===========");
                    for (int i = 0; i < 5; i++) {
                        printNum(Thread.currentThread().getName(), i + 1);
                    }
                    System.out.println("===========线程B输出数字结束===========");
                    lock.notify();
                }
            }
        });
        threadA.setName("A");
        threadB.setName("B");
        // 设置线程A的优先级不能确保确保A先执行，如threadA.setPriority(Thread.MAX_PRIORITY)
        threadA.start();
        try {
            // 休眠1s，让出cpu
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadB.start();
    }

    private static void printNum(String threadName, int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + threadName + "打印数字：" + i);
    }
}
