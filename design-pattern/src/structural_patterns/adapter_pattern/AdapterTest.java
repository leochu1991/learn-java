package structural_patterns.adapter_pattern;

import org.junit.Test;

/**
 * adapter pattern test
 */
public class AdapterTest {
    @Test
    public void test(){
        Target normalTarget = new NormalTarget();
        normalTarget.normalMethod();

        Adapter adapter = new Adapter();
        adapter.normalMethod();
    }
}
