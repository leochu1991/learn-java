package behavioral_patterns.memento_pattern;

import org.junit.Test;

/**
 * memento pattern test
 * 保存对象状态，之后恢复
 */
public class MementoTest {
    @Test
    public void test() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        // 设置状态
        originator.setState("state #1");
        originator.setState("state #2");
        originator.setState("state #3");
        // 添加state #3
        careTaker.addMemento(originator.saveStateToMemento());
        originator.setState("state #4");
        originator.setState("state #5");
        // 添加state #5
        careTaker.addMemento(originator.saveStateToMemento());
        // 恢复状态
        originator.setState(careTaker.getMemento(0).getState());
        System.out.println(String.format("===first state: %s===", originator.getState()));
        originator.setState(careTaker.getMemento(1).getState());
        System.out.println(String.format("===second state: %s===", originator.getState()));
    }
}
