### `Java` 多线程 `Demo`
#### 目录结构
+ `Demo1` : `A`，`B` 线程分别输出数字 `1,2,3,4,5` ，每个线程输出 `5` 个数字
+ `Demo2` : `A`，`B` 线程轮流依次输出数字 `1,2,3,4,5,6,7,8,9,10` ，各输出 `5` 个数字
+ `Demo3` : `B` 线程在 `A` 线程输出 `1,2,3,4,5` 之后输出数字 `1,2,3,4,5` (在线程 `B` 中使用 `A.join()`)
+ `Demo4` : `B` 线程在 `A` 线程输出 `1,2` 之后输出数字 `1,2,3,4,5` ，然后线程 `A` 再输出 `3,4,5` (在线程 `A`中使用 `object.wait(),object.notify()` 进行线程通信)
+ `Deom5` : `CountDownLatch` , `A` , `B` , `C` , `D` 四个线程， `D` 线程在 `A，B，C` 线程完成后执行，`CountDownLatch.await()` , `CountDownLatch.countDown()` , 用于一个线程和一组线程之间的协作
+ `Demo6` : `CyclicBarrier` , `A` , `B` , `C` 三个线程都等待若干时间在某一时间点 (`await()`)就绪后执行下面的语句，`CyclicBarrier.await()` , 用于一组线程在某一时间点上达成一致，可循环使用
+ `Demo7` : `Semaphore` , 用于控制同时执行的线程数，阻塞：`acquire()` 获得许可，`release()` 释放许可；非阻塞：`tryAcquire()`
+ `Demo8` : `Callable` , `FutureTask` 将子线程计算的结果返回给主线程，`Callable` 与 `Runnable` 区别：返回值、带泛型结果 `V` 、抛出异常
+ `Demo9` : `Callable` , 将多个子线程计算结果是否等于预期值返回给主线程，表明有多少个任务执行成功
+ `Demo10` : `Thread` 的 `interrupt()` , `interrupted()` , `isInterrupted()` 方法区别
+ `Demo11` : 生产者消费者问题，生产者生产10个商品，然后消费者消费10个，执行结束
+ `Demo12` : 生产者消费者问题，生产者生产5个商品，然后消费者消费5个，一直循环， `100ms` 后生产者消费者线程中断
+ `Demo13` : `ThreadLocal` , 线程本地变量， `Thread` , `ThreadLocalMap` , `ThreadLocal` 之间的关系