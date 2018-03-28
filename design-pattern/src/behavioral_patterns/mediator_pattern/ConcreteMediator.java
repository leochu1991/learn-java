package behavioral_patterns.mediator_pattern;

/**
 * 具体中介者类
 */
public class ConcreteMediator implements Mediator {
    private ColleagueOne colleagueOne;
    private ColleagueTwo colleagueTwo;

    // 最少知识原则
    public void setColleagueOne(ColleagueOne colleagueOne) {
        this.colleagueOne = colleagueOne;
    }

    public void setColleagueTwo(ColleagueTwo colleagueTwo) {
        this.colleagueTwo = colleagueTwo;
    }

    @Override
    public void sendMessage(Colleague colleague, String message) {
        if (colleague.equals(colleagueOne)) {
            colleagueTwo.onMessage(message);
        } else if (colleague.equals(colleagueTwo)) {
            colleagueOne.onMessage(message);
        } else {
            System.out.println("===no colleague found===");
        }
    }
}
