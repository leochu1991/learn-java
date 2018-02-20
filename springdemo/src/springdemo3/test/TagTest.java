package springdemo3.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo3.bean.User;

/**
 * 自定义标签解析测试类
 */
public class TagTest {
    @Test
    public void test() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("springdemo3/resources/spring-customtag.xml");
        // 根据myns子空间user元素的id获取bean
        User user = (User) atx.getBean("root");
        System.out.println(String.format("user : %s\nid = %s\nusername = %s\nsex = %s\nage = %d",
                user.toString(), user.getId(), user.getUsername(), user.getSex(), user.getAge()));
    }
}
