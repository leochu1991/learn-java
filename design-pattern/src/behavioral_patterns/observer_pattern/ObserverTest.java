package behavioral_patterns.observer_pattern;

import org.junit.Test;

/**
 * observer pattern test
 */
public class ObserverTest {
    @Test
    public void test() {
        Subject subjectA = new SubjectA();
        Observer observerA = new ObserverA(subjectA, "observerA");
        Observer observerB = new ObserverB(subjectA, "observerB");
        Observer observerC = new ObserverC(subjectA, "observerC");

        subjectA.attach(observerA);
        subjectA.attach(observerB);
        subjectA.attach(observerC);

        System.out.println("第一次线程状态是: 新建");
        subjectA.setState(StateEnum.NEW.getDesc());

        System.out.println("第二次更新线程状态: 可运行");
        subjectA.setState(StateEnum.RUNNABLE.getDesc());

        System.out.println("第三次移除observerA后线程状态是: 阻塞");
        subjectA.detach(observerA);
        subjectA.setState(StateEnum.BLOCKED.getDesc());
    }
}
