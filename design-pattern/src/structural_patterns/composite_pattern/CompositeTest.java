package structural_patterns.composite_pattern;

import org.junit.Test;

/**
 * composite pattern test
 * 组合模式，也叫部分整体模式，树形结构
 * 举例:剧集和子集;树枝和树叶
 */
public class CompositeTest {
    @Test
    public void test() {
        Component root = new Composite("root");
        // 分枝compositeX
        Component compositeX = new Composite("compositeX");
        Leaf leafXA = new Leaf("leafXA");
        Leaf leafXB = new Leaf("leafXB");
        // compositeX的分枝compositeXX
        Component compositeXX = new Composite("compositeXX");
        Leaf leafXXA = new Leaf("XXA");
        compositeXX.add(leafXXA);

        compositeX.add(leafXA);
        compositeX.add(leafXB);
        compositeX.add(compositeXX);
        // root的叶子leafC
        Leaf leafC = new Leaf("leafC");

        root.add(compositeX);
        root.add(leafC);

        root.show(1);
    }
}
