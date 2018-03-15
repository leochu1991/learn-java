package demo.demo7;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore:信号量，用于控制同时执行的线程数，阻塞：acquire()获得许可，release()释放许可；非阻塞：tryAcquire()
 * 功能：创建五个线程，三个许可，线程获得许可才能执行，同一时刻只有三个线程能获得许可
 */
public class Demo7 {
    public static void main(String[] args) {
        // 许可数
        int permits = 3;
        // 线程数
        int threadNum = 5;
        // 信号量
        final Semaphore semaphore = new Semaphore(permits);
        System.out.println(threadNum + "个线程获取" + permits + "个信号量许可，开始执行");
        for (int i = 0, threadName = 'A'; i < threadNum; i++, threadName++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = new Random().nextInt(500);
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "获得许可，执行任务耗时：" + prepareTime + "毫秒");
                    try {
                        TimeUnit.MILLISECONDS.sleep(prepareTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    semaphore.release();
                    System.out.println("线程" + Thread.currentThread().getName() + "已经释放许可，其它线程可以获得许可了");
                }
            }, String.valueOf((char) threadName)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程执行完毕，许可释放完毕");
    }
}
