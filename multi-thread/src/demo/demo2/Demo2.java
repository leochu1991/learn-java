package demo.demo2;

/**
 * 功能：A，B线程(线程先后无序)轮流依次输出数字1,2,3,4,5,6,7,8,9,10
 */
public class Demo2 {
    public static volatile int count = 1;

    public static void main(String[] args) {
        final Object lock = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    printNum(Thread.currentThread().getName(), lock);
                }
            }
        };
        Thread threadA = new Thread(runnable, "A");
        Thread threadB = new Thread(runnable, "B");
        threadA.start();
        threadB.start();
    }

    private static void printNum(String threadName, Object lock) {
        while (count <= 10) {
            // notify其他线程
            lock.notifyAll();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + threadName + "打印数字：" + count);
            count++;
            try {
                // lock.wait();
                lock.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
