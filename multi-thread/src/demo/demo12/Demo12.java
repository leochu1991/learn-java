package demo.demo12;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static demo.demo12.Demo12.*;


/**
 * 生产者消费者问题：生产者生产5个商品，然后消费者消费5个，一直循环，100ms后生产者消费者线程中断
 */
class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// 生产者
class Producer implements Runnable {

    @Override
    public void run() {
        synchronized (lock) {
            while (flag && !Thread.currentThread().isInterrupted()) {
                if (products.size() >= count) {
                    try {
                        System.out.println(String.format("商品数量过多，线程：%s 不再生产。。。", Thread.currentThread().getName()));
                        flag = false;
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Random random = new Random(1000);
                for (int i = 0; i < count; i++) {
                    String name = "商品" + (i + 1);
                    double a = random.nextDouble();
                    double b = random.nextDouble();
                    BigDecimal price = new BigDecimal(a / b, new MathContext(2));
                    Product product = new Product(name, price);
                    products.add(product);
                    System.out.println(String.format("生产者生产商品:%s，已有商品数量：%d", product.toString(), products.size()));
                }
                lock.notifyAll();
            }
        }
    }
}

// 消费者
class Consumer implements Runnable {

    @Override
    public void run() {
        synchronized (lock) {
            while (!flag && !Thread.currentThread().isInterrupted()) {
                if (products.size() < 1) {
                    try {
                        System.out.println(String.format("商品数量不足，线程：%s 等待。。。", Thread.currentThread().getName()));
                        flag = true;
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (products.size() > 0) {
                    Product product = products.remove(0);
                    System.out.println(String.format("消费者消费商品：%s，剩余商品数量：%d", product, products.size()));
                }
                lock.notifyAll();
            }
        }
    }
}

public class Demo12 {
    // 商品生产数量限制
    public static int count = 5;
    // 生产商品和消费商品列表
    public static List<Product> products = new LinkedList<>();
    // 锁
    public static final Object lock = new Object();
    // 生产者执行标志，true表示执行，false表示消费者执行
    public static volatile boolean flag = true;

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread producerThread = new Thread(producer, "生产者");
        producerThread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread consumerThread = new Thread(consumer, "消费者");
        consumerThread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("100ms 后 Main线程开始中断生产者消费者线程。。。");
            producerThread.interrupt();
            consumerThread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
