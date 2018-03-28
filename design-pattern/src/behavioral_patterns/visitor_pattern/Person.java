package behavioral_patterns.visitor_pattern;

/**
 * 人接口
 */
public interface Person {
    void accept(Reaction visitor);
}
