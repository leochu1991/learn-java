package springdemo1.bean;

import org.springframework.stereotype.Component;

/**
 * Created by leochu on 2017/9/28.
 */
@Component
public class HelloSpring1 {
    public String sayHello(){
        return "Hello,Spring1";
    }
}
