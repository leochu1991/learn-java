package behavioral_patterns.observer_pattern;

import org.junit.Test;

/**
 * observer pattern test
 */
public class ObserverTest {
    @Test
    public void test() {
        Subject concreteSubject = new ConcreteSubject();
        Observer observerA = new ObserverA(concreteSubject, "observerA");
        Observer observerB = new ObserverB(concreteSubject, "observerB");
        Observer observerC = new ObserverC(concreteSubject, "observerC");

        concreteSubject.attach(observerA);
        concreteSubject.attach(observerB);
        concreteSubject.attach(observerC);

        System.out.println("第一次线程状态是: 新建");
        concreteSubject.setState(StateEnum.NEW.getDesc());

        System.out.println("第二次更新线程状态: 可运行");
        concreteSubject.setState(StateEnum.RUNNABLE.getDesc());

        System.out.println("第三次移除observerA后线程状态是: 阻塞");
        concreteSubject.detach(observerA);
        concreteSubject.setState(StateEnum.BLOCKED.getDesc());
    }
}
