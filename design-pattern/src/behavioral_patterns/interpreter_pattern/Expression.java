package behavioral_patterns.interpreter_pattern;

/**
 * 表达式接口
 */
public interface Expression {
    // context待解析的字符串
    boolean interpret(String context);
}
