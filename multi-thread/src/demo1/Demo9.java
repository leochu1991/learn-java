package demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能：将子线程计算的结果返回给主线程，使用callable,futuretask
 * callable和runnable区别：callable返回泛型结果V，抛出异常
 * futuretask的get方法会阻塞主线程，如果不希望阻塞主线程，可以考虑利用 ExecutorService，把 FutureTask 放到线程池去管理执行。
 */
public class Demo81 {
    public static void main(String[] args) {
        // 创建callable
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(1000);
                System.out.println("开始执行futuretask。。。");
                Boolean result = false;
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                if (sum == 5050) {
                    result = true;
                }
                System.out.println("futuretask执行完成。。。");
                return result;
            }
        };
        int count = 0;
        for (int i = 0; i < 20; i++) {
            // 创建futuretask
            FutureTask<Boolean> futureTask = new FutureTask<>(callable);
            new Thread(futureTask).start();
            try {
                // System.out.println("开始调用futuretask.get()方法。。。");
                Boolean result = futureTask.get();
                // System.out.println("1+2+3...+100 = 5050 ??? " + result);
                if (result) {
                    count++;
                }
                System.out.println("第" + i + "次任务时 result = " + result + ",count = " + count);
                // System.out.println("调用futuretask.get()方法结束。。。");
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("count = " + count);
    }
}
