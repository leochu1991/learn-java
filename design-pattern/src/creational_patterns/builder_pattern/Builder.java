package creational_patterns.builder_pattern;

/**
 * 建造者接口:建造各个部件;返回产品
 */
public interface Builder {
    void buildPartA();

    void buildPartB();

    Product getProduct();
}
