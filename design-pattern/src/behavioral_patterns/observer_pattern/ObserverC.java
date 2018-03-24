package behavioral_patterns.observer_pattern;

/**
 * 观察者C
 */
public class ObserverC implements Observer {
    private Subject subject;
    private String name;

    public ObserverC(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(String.format("Hi, %s, 线程的状态是: %s", name, subject.getState()));
    }
}
