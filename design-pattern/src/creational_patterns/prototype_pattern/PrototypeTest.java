package creational_patterns.prototype_pattern;

import org.junit.Test;

/**
 * prototype pattern test
 */
public class PrototypeTest {
    @Test
    public void test() throws CloneNotSupportedException {
        Resume oneResume = new OneResume("oneResume", 10, "Baidu");
        System.out.println("==> oneResume: " + oneResume);
        Resume oneResumeCopy = oneResume.cloneResume();
        System.out.println("==> oneResumeCopy: " + oneResumeCopy);

        TwoResume twoResume = new TwoResume();
        twoResume.setName("twoResume");
        twoResume.setAge(13);
        twoResume.setWorkExperience(new WorkExperience("Ali").getWorkExperience());
        System.out.println("==> twoResume: " + twoResume);
        Resume twoResumeCopy = twoResume.cloneResume();
        System.out.println("==> twoResumeCopy: " + twoResumeCopy);
    }
}
