package demo1;

/**
 * 功能：Thread的interrupt(),interrupted(),isInterrupted()方法区别
 * 调用interrupt()方法会set(重置)interrupt status为true，threadA在catch到InterruptedException后会clear(清除)interrupt status为false
 * Thread.interrupted()类方法，会clear(清除)interrupt status为false
 * 调用interrupted()方法只判断interrupt status，不改变状态
 * <p>
 * synchronized,Lock.lock(),inputSteam.read()等不能响应中断，得不到资源就会阻塞
 */
public class Demo11 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 休眠20s，让Main Thread调用threadA.interrupt()
                    System.out.println("In threadA, call Thread.sleep()。。。：休眠20s");
                    Thread.sleep(20000);
                    // 不会执行
                    System.out.println("In threadA, After calling Thread.sleep()。。。");
                } catch (InterruptedException e) {
                    // threadA catch InterruptedException后将threadA's interrupt status清除，为false
                    System.out.println(String.format("In threadA's InterruptedException。。。" +
                            "after calling threadA.interrupt(),threadA's interrupt status is %b", Thread.currentThread().isInterrupted()));
                    // 将threadA's interrupt status重置为true
                    Thread.currentThread().interrupt();
                    System.out.println(String.format("========== call threadA.interrupt() second time," +
                            "threadA's interrupt status is %b", Thread.currentThread().isInterrupted()));
                    // 清除threadA's interrupt status，为false
                    Thread.interrupted();
                    System.out.println(String.format("========== call Thread.interrupted() first time," +
                            "threadA's interrupt status is %b", Thread.currentThread().isInterrupted()));
                    // 不起作用，仍为false
                    Thread.interrupted();
                    System.out.println(String.format("========== call Thread.interrupted() second time," +
                            "threadA's interrupt status is %b", Thread.currentThread().isInterrupted()));
                    return;
                }
                System.out.println("threadA finished normally。。。");
            }
        });
        threadA.start();
        // main线程休眠2s，让出cpu
        try {
            System.out.println("In Main Thread, call Thread.sleep()。。。：休眠2s，让threadA执行。。。");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("In Main's InterruptedException。。。");
        }
        // 调用threadA.interrupt()方法前，threadA的interrupt status为false
        System.out.println(String.format("In Main Thread, call threadA.interrupt()。。。" +
                "before calling threadA.interrupt(),threadA's interrupt status is %b", threadA.isInterrupted()));
        threadA.interrupt();
        // 调用threadA.interrupt()方法后，则显示threadA的interrupt status为true
        System.out.println(String.format("Main Thread finished normally。。。" +
                "after calling threadA.interrupt(),before threadA catch InterruptedException,threadA's interrupt status is %b", threadA.isInterrupted()));
    }
}
