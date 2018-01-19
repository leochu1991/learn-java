package creational_patterns.factory_pattern.abstract_factory;

/**
 * 抽象工厂模式：一个抽象工厂包含所有不同产品（汽车和汽车轮胎）
 */
public abstract class AbstractFactory {
    abstract Car getCar(String carName);

    abstract Tyre getTyre(String tyreName);
}
