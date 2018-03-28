package behavioral_patterns.visitor_pattern;

import org.junit.Test;

/**
 * visitor pattern test
 * 适用于数据结构相对稳定，数据操作多变的系统；双分派
 * 举例: 人分为男人女人，人的状态多变，每种状态都有男女两种反应
 */
public class VisitorTest {
    @Test
    public void test() {
        ObjectStructure objectStructure = new ObjectStructure();
        Man man = new Man();
        Woman woman = new Woman();

        objectStructure.attach(man);
        objectStructure.attach(woman);

        Happiness happiness = new Happiness();
        objectStructure.showReaction(happiness);

        Sadness sadness = new Sadness();
        objectStructure.showReaction(sadness);
    }
}
