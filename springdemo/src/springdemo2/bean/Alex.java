package springdemo2.bean;

import org.springframework.stereotype.Component;

/**
 * Created by leochu on 2018/1/30.
 */
@Component("alex")
public class Alex implements Person {
    @Override
    @LogAnnotation(methodName = "爱好", intention = "显示个人爱好")
    public void displayHobby(String name, String hobby) {
        System.out.println(String.format("%s喜欢%s", name, hobby));
    }
}
