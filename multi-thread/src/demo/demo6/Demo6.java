package demo.demo6;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 功能：创建A，B，C三个线程，A，B，C线程都等待若干时间后打印完成语句，cyclicBarrier.await()，类似于运动员同一起跑线跑步
 * CyclicBarrier 用于一组或几组线程，比如一组线程需要在一个时间点上达成一致，例如同时开始一个工作。
 * 另外，CyclicBarrier 的循环特性和构造函数所接受的 Runnable 参数也是 CountDownLatch 所不具备的。
 */
public class Demo6 {
    public static void main(String[] args) {
        // 设置等待线程数
        int count = 3;
        // 循环栅栏
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for (int i = 0, threadName = 'A'; i < 3; i++, threadName++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = new Random().nextInt(5000);
                    System.out.println("线程" + Thread.currentThread().getName() + "正在准备等待：" + prepareTime + "毫秒");
                    try {
                        Thread.sleep(prepareTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "已经准备好了，等待其它线程");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "开始执行！！！");
                }
            }, String.valueOf((char) threadName)).start();
        }
    }
}
