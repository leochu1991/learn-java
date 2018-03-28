package structural_patterns.composite_pattern;

/**
 * 分枝或叶子
 */
public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void show(int depth);
}
