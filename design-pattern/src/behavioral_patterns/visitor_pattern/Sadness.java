package behavioral_patterns.visitor_pattern;

/**
 * 伤心
 */
public class Sadness implements Reaction {

    @Override
    public void getManReaction(Man man) {
        int index = man.toString().lastIndexOf(".");
        System.out.println("sadness: " + man.toString().substring(index + 1));
    }

    @Override
    public void getWomanReaction(Person woman) {
        int index = woman.toString().lastIndexOf(".");
        System.out.println("sadness: " + woman.toString().substring(index + 1));
    }
}
