package structural_patterns.decorator_pattern;

/**
 * 接口实现类
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation(String name) {
        System.out.println(String.format("===执行动作: %s===", name));
    }
}
