package behavioral_patterns.state_pattern;

import org.junit.Test;

/**
 * state pattern test
 * 对象行为依赖于状态，内在状态改变时，行为改变
 * 好处: 减少条件分支语句
 */
public class StateTest {
    @Test
    public void test() {
        Context context = new Context();
        State stateA = new ConcreteStateA("stateA");
        State stateB = new ConcreteStateB("stateB");
        State stateC = new ConcreteStateC("stateC");
        // 状态改变，行为改变，方法名handleState不变
        context.setState(stateA);
        context.handleState();

        context.setState(stateB);
        context.handleState();

        context.setState(stateC);
        context.handleState();
    }
}
