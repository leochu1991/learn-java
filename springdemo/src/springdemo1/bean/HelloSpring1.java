package springdemo1.bean;

import org.springframework.stereotype.Component;

/**
 * hellospring1
 */
@Component
public class HelloSpring1 {
    public String sayHello() {
        return "Hello,Spring1";
    }
}
