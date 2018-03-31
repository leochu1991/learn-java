package behavioral_patterns.iterator_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合类
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    public void add(Object object) {
        items.add(object);
    }

    public int count() {
        return items.size();
    }

    public Object getItem(int index) {
        Object ret = null;
        if (index < count()) {
            ret = items.get(index);
        }
        return ret;
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this);
    }
}
