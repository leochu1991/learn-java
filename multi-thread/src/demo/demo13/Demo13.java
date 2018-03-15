package demo.demo13;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal：线程本地变量
 */
class User {
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

public class Demo13 {
    public static void main(String[] args) {
        final User user1 = new User();
        final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
        userThreadLocal.set(user1);
        System.out.println("main-thread's threadlocal is: " + userThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user2 = new User();
                // 相同的threadlocal，线程不同，value不同
                userThreadLocal.set(user2);
                System.out.println("thread-A's threadlocal is: " + userThreadLocal.get());
                // remove当前线程的Entry，防止存在强引用，内存泄漏
                userThreadLocal.remove();
            }
        }, "thread-A").start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // remove main线程的Entry
        userThreadLocal.remove();
    }
}
