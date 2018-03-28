package structural_patterns.facade_pattern;

import org.junit.Test;

/**
 * facade pattern test
 * 外观模式，也叫门面模式；依赖倒转(面向接口编程) and 迪米特法则(client只与门面类发生作用)
 * 举例：买基金(门面) vs 买股票；前台-中台(门面)-后台 vs 前台-后台
 */
public class FacadeTest {
    @Test
    public void test() {
        // 四个子系统
        SubSystemOne subSystemOne = new SubSystemOne();
        SubSystemTwo subSystemTwo = new SubSystemTwo();
        SubSystemThree subSystemThree = new SubSystemThree();
        SubSystemFour subSystemFour = new SubSystemFour();
        // 门面实现类
        OneFacade oneFacade = new OneFacade(subSystemOne, subSystemTwo, subSystemThree, subSystemFour);
        oneFacade.methodA();
        oneFacade.methodB();
    }
}
