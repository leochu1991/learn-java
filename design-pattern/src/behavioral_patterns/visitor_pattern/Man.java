package behavioral_patterns.visitor_pattern;

/**
 * 男人
 */
public class Man implements Person {
    @Override
    public void accept(Reaction visitor) {
        visitor.getManReaction(this);
    }
}
