package creational_patterns.factory_pattern.factory_method;

/**
 * 工厂方法模式：一个工厂可以生产一种产品的不同款
 */
public abstract class AbstractFactory {
    abstract Car getCar(String carName);
}
