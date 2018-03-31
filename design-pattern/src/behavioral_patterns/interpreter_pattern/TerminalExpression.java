package behavioral_patterns.interpreter_pattern;

/**
 * 终端表达式
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean interpret(String context) {
        return data.contains(context);
    }
}
