package creational_patterns.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造的产品
 */
public class Product {
    private String productName;
    private List<String> parts = new ArrayList<>();

    public Product(String productName) {
        this.productName = productName;
    }

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品: " + productName);
        for (String part : parts) {
            System.out.println("==>建造了: " + part);
        }
    }
}
