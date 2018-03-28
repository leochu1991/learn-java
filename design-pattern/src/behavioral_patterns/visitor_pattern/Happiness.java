package behavioral_patterns.visitor_pattern;

/**
 * 快乐
 */
public class Happiness implements Reaction {
    @Override
    public void getManReaction(Man man) {
        int index = man.toString().lastIndexOf(".");
        System.out.println("happiness: " + man.toString().substring(index + 1));
    }

    @Override
    public void getWomanReaction(Person woman) {
        int index = woman.toString().lastIndexOf(".");
        System.out.println("happiness: " + woman.toString().substring(index + 1));
    }
}
