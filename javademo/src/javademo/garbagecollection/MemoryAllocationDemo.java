package javademo.garbagecollection;

/**
 * 内存分配，new对象分配在Eden区，若内存不足，会进行Minor GC，可注释allocation3,allocation4查看区别
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -Xms20M
 * -Xmx20M
 * -Xmn7M
 * -XX:SurvivorRatio=8
 */
public class MemoryAllocationDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        // Eden大小为5.6M，内存不足，发生Minor GC
        allocation3 = new byte[2 * _1MB];
        // 大对象直接进入Old
        allocation4 = new byte[4 * _1MB];
    }
}
