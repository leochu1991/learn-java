package behavioral_patterns.visitor_pattern;

/**
 * 女人
 */
public class Woman implements Person {
    @Override
    public void accept(Reaction visitor) {
        visitor.getWomanReaction(this);
    }
}
