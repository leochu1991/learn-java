package springdemo2.bean;

import org.springframework.stereotype.Component;

/**
 * Created by leochu on 2018/1/30.
 */
@Component
public interface Person {
    // 显示爱好
    void displayHobby(String name, String hobby);
}
