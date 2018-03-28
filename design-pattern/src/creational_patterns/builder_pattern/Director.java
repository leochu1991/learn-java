package creational_patterns.builder_pattern;

/**
 * 组装建造过程
 */
public class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
