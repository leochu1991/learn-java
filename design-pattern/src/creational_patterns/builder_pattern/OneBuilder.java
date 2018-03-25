package creational_patterns.builder_pattern;

/**
 * 建造者一
 */
public class OneBuilder implements Builder {
    Product productOne = new Product("One");

    @Override
    public void buildPartA() {
        productOne.add("部件一");
    }

    @Override
    public void buildPartB() {
        productOne.add("部件二");
    }

    @Override
    public Product getProduct() {
        return productOne;
    }
}
