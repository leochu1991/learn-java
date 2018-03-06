package javademo.garbagecollection;

/**
 * 打印GC日志
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 */
public class PrintGCDetailsDemo {

    public static void main(String[] args) {
        PrintGCDetailsDemo gcDetails = new PrintGCDetailsDemo();
        Object[] objects = gcDetails.createObjects();
        gcDetails.clearReferences(objects);
        System.gc();
    }

    private void clearReferences(Object[] objects) {
        objects = null;
    }

    private Object[] createObjects() {
        return new Object[]{new byte[1024 * 1024], new byte[1024 * 1024]};
    }
}
