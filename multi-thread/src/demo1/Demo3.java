package demo1;

/**
 *  功能：B线程在A线程输出1,2,3,4,5之后输出数字1,2,3,4,5(在线程B中使用A.join())
 */
public class Demo3 {
    public static void main(String[] args) {
        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                printNum(Thread.currentThread().getName());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===========线程B等待线程A执行结束===========");
                try {
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===========线程B开始打印数字===========");
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + threadName + "打印数字：" + i);
        }
    }
}
