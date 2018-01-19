package demo1;

/**
 * 功能：A，B线程(线程先后无序)轮流依次输出数字1,2,3,4,5(没有加锁，sleep之后cpu依次执行线程A，线程B)
 * 不要用JUnit测试，需要主线程main
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                printNum(Thread.currentThread().getName());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                printNum(Thread.currentThread().getName());
            }
        });
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }

    private static void printNum(String threadName) {
        int i = 0;
        while (i++ < 5) {
            System.out.println("线程" + threadName + "打印数字：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
