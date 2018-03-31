package behavioral_patterns.iterator_pattern;

/**
 * 具体迭代器类
 */
public class ConcreteIterator implements Iterator {
    // 聚合对象
    private ConcreteAggregate concreteAggregate;
    // 迭代时元素下标
    private int index = 0;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public boolean hasNext() {
        return index < concreteAggregate.count();
    }

    @Override
    public Object next() {
        Object ret = null;
        if (hasNext()) {
            ret = concreteAggregate.getItem(index);
            index++;
        }
        return ret;
    }
}
