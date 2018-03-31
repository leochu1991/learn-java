package behavioral_patterns.iterator_pattern;

/**
 * 聚合对象接口
 */
public interface Aggregate {
    // 返回迭代器
    Iterator getIterator();
}
