package creational_patterns.builder_pattern;

import org.junit.Test;

/**
 * builder pattern test
 */
public class BuilderTest {
    @Test
    public void test() {
        Director director = new Director();
        Builder oneBuilder = new OneBuilder();
        Builder twoBuilder = new TwoBuilder();

        director.construct(oneBuilder);
        Product oneBuilderProduct = oneBuilder.getProduct();
        oneBuilderProduct.show();

        director.construct(twoBuilder);
        Product twoProduct = twoBuilder.getProduct();
        twoProduct.show();
    }
}
