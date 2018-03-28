package creational_patterns.builder_pattern;

/**
 * 建造者二
 */
public class TwoBuilder implements Builder {
    Product productTwo = new Product("Two");

    @Override
    public void buildPartA() {
        productTwo.add("部件X");
    }

    @Override
    public void buildPartB() {
        productTwo.add("部件Y");
    }

    @Override
    public Product getProduct() {
        return productTwo;
    }
}
