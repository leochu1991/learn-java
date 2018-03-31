package behavioral_patterns.chain_of_responsibility_pattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * chain of responsibility pattern test
 * 多个处理对象都有可能处理请求，对象保存下一个对象的引用，对象之间形成一条链
 */
public class ChainResponsibilityTest {
    @Test
    public void test() {
        Handler handlerone = new HandlerOne("handlerone");
        Handler handlertwo = new HandlerTwo("handlertwo");
        Handler handlerthree = new HandlerThree("handlerthree");
        // 设置对象间引用
        handlerone.setNextHandler(handlertwo);
        handlertwo.setNextHandler(handlerthree);
        // 生成多个请求
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("PayRise", 500));
        requests.add(new Request("PayRise", 2500));
        requests.add(new Request("PayRise", 3500));
        requests.add(new Request("SickLeave", 2));
        requests.add(new Request("SickLeave", 5));
        for (Request request : requests) {
            handlerone.dealRequest(request);
        }
    }
}
