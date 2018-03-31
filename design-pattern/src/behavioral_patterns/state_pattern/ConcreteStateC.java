package behavioral_patterns.state_pattern;

/**
 * 具体状态C
 */
public class ConcreteStateC implements State {
    private String name;

    public ConcreteStateC(String name) {
        this.name = name;
    }

    @Override
    public void doSomething(Context context) {
        context.setState(this);
        System.out.println(String.format("===current state: %s===", context.getState().toString()));
    }

    @Override
    public String toString() {
        return "ConcreteStateC{" +
                "name='" + name + '\'' +
                '}';
    }
}
