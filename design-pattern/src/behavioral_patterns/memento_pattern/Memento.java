package behavioral_patterns.memento_pattern;

/**
 * 备忘录类
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
