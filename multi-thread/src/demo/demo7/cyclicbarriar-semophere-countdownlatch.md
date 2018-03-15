### `CountDownLatch,CyclicBarrier,Semaphore` 区别

#### 区别

+ `CountDownLatch` 和 `CyclicBarrier` 都能实现线程间等待，区别：
  + `CountDownLatch` 用于某个线程等待若干个其他线程执行完之后再执行；`CyclicBarrier` 用于一组线程互相等待至某个状态，然后这一组线程再同时执行
  + `CountDownLatch` 不能重用，而 `CyclicBarrier` 可以重用
+ `Semaphore` 和锁类似，它用于控制对某组资源的访问权限（许可）

#### 参考文章

+ [Java并发编程：CountDownLatch、CyclicBarrier和Semaphore](http://www.cnblogs.com/dolphin0520/p/3920397.html)