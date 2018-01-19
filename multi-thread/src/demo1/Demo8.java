package demo1;

import java.util.concurrent.*;

/**
 * 功能：将子线程计算的结果返回给主线程，使用callable,futuretask
 * callable和runnable区别：callable返回泛型结果V，抛出异常
 * futuretask的get方法会阻塞主线程，如果不希望阻塞主线程，可以考虑利用 ExecutorService，把 FutureTask 放到线程池去管理执行。
 */
public class Demo8 {
    public static void main(String[] args) {
        // 创建callable
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("开始执行futuretask。。。");
                Integer result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("futuretask执行完成。。。");
                return result;
            }
        };
        // 创建futuretask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("开始调用futuretask.get()方法。。。");
            Integer result = futureTask.get();
            System.out.println("1+2+3...+100 = " + result);
            System.out.println("调用futuretask.get()方法结束。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
