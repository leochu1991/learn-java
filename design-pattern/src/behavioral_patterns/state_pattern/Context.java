package behavioral_patterns.state_pattern;

/**
 * context类，维护state
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handleState() {
        state.doSomething(this);
    }
}
