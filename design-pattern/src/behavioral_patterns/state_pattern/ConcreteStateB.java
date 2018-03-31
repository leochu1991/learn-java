package behavioral_patterns.state_pattern;

/**
 * 具体状态B
 */
public class ConcreteStateB implements State {
    private String name;

    public ConcreteStateB(String name) {
        this.name = name;
    }

    @Override
    public void doSomething(Context context) {
        context.setState(this);
        System.out.println(String.format("===current state: %s===", context.getState().toString()));
    }

    @Override
    public String toString() {
        return "ConcreteStateB{" +
                "name='" + name + '\'' +
                '}';
    }
}
