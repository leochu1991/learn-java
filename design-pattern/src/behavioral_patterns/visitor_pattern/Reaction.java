package behavioral_patterns.visitor_pattern;

/**
 * 状态接口，男女两种，稳定
 */
public interface Reaction {
    void getManReaction(Man man);

    void getWomanReaction(Person woman);
}
