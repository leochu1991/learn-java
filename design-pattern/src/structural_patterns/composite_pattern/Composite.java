package structural_patterns.composite_pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 分枝，包含分支和叶子
 */
public class Composite extends Component {
    private String name;
    private List<Component> subComposite = new LinkedList<Component>();

    public Composite(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void add(Component component) {
        subComposite.add(component);
    }

    @Override
    public void remove(Component component) {
        subComposite.remove(component);
    }

    @Override
    public void show(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2 * depth - 1; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.append(name));
        // show分枝
        if (subComposite != null && subComposite.size() > 0) {
            for (Component component : subComposite) {
                component.show(depth + 2);
            }
        }
    }
}
