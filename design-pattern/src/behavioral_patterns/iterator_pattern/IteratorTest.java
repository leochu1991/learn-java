package behavioral_patterns.iterator_pattern;

import org.junit.Test;

/**
 * iterator pattern test
 * 遍历聚合对象
 */
public class IteratorTest {
    @Test
    public void test() {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        concreteAggregate.add("object #1");
        concreteAggregate.add("object #2");
        concreteAggregate.add("object #3");
        concreteAggregate.add("object #4");
        concreteAggregate.add("object #5");
        concreteAggregate.add("object #6");

        ConcreteIterator concreteIterator = (ConcreteIterator) concreteAggregate.getIterator();
        while (concreteIterator.hasNext()) {
            System.out.printf("===next object: %s===%n", concreteIterator.next());
        }
    }
}
