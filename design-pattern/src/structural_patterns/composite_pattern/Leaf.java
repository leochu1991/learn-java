package structural_patterns.composite_pattern;

/**
 * 叶子
 */
public class Leaf extends Component {
    private String name;

    public Leaf(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("===叶子不能增加分枝===");
    }

    @Override
    public void remove(Component component) {
        System.out.println("===叶子不能移除分枝===");
    }

    @Override
    public void show(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2 * depth - 1; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.append(name));
    }
}
