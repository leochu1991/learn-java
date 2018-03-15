package demo.demo5;

import java.util.concurrent.CountDownLatch;

/**
 * 功能：创建A，B，C，D四个线程，D线程在A，B，C线程完成后执行，CountDownLatch.await(),CountDownLatch.countDown()
 * CountDownLatch 适用于一组线程和另一个主线程之间的工作协作。
 * 一个主线程等待一组工作线程的任务完毕才继续它的执行是使用 CountDownLatch 的主要场景。
 */
public class Demo5 {
    public static void main(String[] args) {
        int count = 3;
        // 倒计数器
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("===========线程D等待线程A,B,C执行完成==========");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===========线程A,B,C执行完成，即将执行线程D============");
                System.out.println("线程" + Thread.currentThread().getName() + "正在执行。。。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "执行完成！！！");
            }
        });
        threadD.setName("D");
        threadD.start();
        // 休眠1s使得cpu启动线程D，先执行线程D
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0, threadName = 'A'; i < 3; i++, threadName++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName() + "正在执行。。。");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "执行结束。。。");
                    countDownLatch.countDown();
                }
            }, String.valueOf((char) threadName)).start();
        }
    }
}
