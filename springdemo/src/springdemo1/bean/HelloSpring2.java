package springdemo1.bean;

import org.springframework.stereotype.Component;

/**
 * hellospring2
 */
@Component("helloSpring2")
public class HelloSpring2 {
    public String sayHello() {
        return "Hello,Spring2";
    }
}
