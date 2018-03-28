package structural_patterns.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元创建工厂,hashmap保存实例对象
 */
public class FlyweightFactory {
    // 保存创建对象map
    private static final Map<String, Flyweight> flyweightMap = new HashMap<String, Flyweight>();

    public static Flyweight getFlyweight(String colorName) {
        Flyweight flyweight = flyweightMap.get(colorName);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(colorName);
            flyweightMap.put(colorName, flyweight);
            System.out.println(String.format("===创建具体享元,color: %s===", colorName));
        }
        return flyweight;
    }
}
