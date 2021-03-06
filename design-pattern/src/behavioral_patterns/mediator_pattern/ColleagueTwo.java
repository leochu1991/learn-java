package behavioral_patterns.mediator_pattern;

/**
 * 对象类一
 */
public class ColleagueTwo implements Colleague {
    private String name;
    private Mediator mediator;

    public ColleagueTwo(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    @Override
    public void onMessage(String message) {
        System.out.println(String.format("===[%s] receive message: %s===", name, message));
    }
}
