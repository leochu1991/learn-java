package behavioral_patterns.observer_pattern;

/**
 * 观察者B
 */
public class ObserverB implements Observer {
    private Subject subject;
    private String name;

    public ObserverB(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(String.format("Hi, %s, 线程的状态是: %s", name, subject.getState()));
    }
}
