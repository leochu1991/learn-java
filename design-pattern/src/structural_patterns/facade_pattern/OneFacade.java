package structural_patterns.facade_pattern;

/**
 * 门面实现类
 */
public class OneFacade implements Facade {
    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;
    private SubSystemFour subSystemFour;

    public OneFacade(SubSystemOne subSystemOne, SubSystemTwo subSystemTwo, SubSystemThree subSystemThree, SubSystemFour subSystemFour) {
        this.subSystemOne = subSystemOne;
        this.subSystemTwo = subSystemTwo;
        this.subSystemThree = subSystemThree;
        this.subSystemFour = subSystemFour;
    }

    @Override
    public void methodA() {
        System.out.println("===这是OneFacade的methodA()===");
        subSystemOne.methodOne();
        subSystemThree.methodThree();
    }

    @Override
    public void methodB() {
        System.out.println("===这是OneFacade的methodB()===");
        subSystemTwo.methodTwo();
        subSystemFour.methodFour();
    }
}
