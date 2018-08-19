package springdemo2.bean;

import org.springframework.stereotype.Component;

/**
 * person接口
 */
@Component
public interface Person {
    // 显示爱好
    void displayHobby(String name, String hobby);
}
