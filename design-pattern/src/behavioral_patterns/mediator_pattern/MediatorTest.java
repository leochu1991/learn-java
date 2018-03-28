package behavioral_patterns.mediator_pattern;

import org.junit.Test;

/**
 * mediator pattern test
 * 用中介对象封装一系列对象的交互，对象之间松耦合
 * 举例: 星型结构, 迪米特法则
 */
public class MediatorTest {
    @Test
    public void test() {
        ColleagueOne colleagueOne = new ColleagueOne("colleagueOne");
        ColleagueTwo colleagueTwo = new ColleagueTwo("colleagueTwo");

        ConcreteMediator concreteMediator = new ConcreteMediator();
        concreteMediator.setColleagueOne(colleagueOne);
        concreteMediator.setColleagueTwo(colleagueTwo);

        colleagueOne.setMediator(concreteMediator);
        colleagueTwo.setMediator(concreteMediator);

        colleagueOne.sendMessage("hello, how are you");
        colleagueTwo.sendMessage("fine, thank you");
    }
}
