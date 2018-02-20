package springdemo2.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo2.bean.Person;

/**
 * 自定义注解实现日志打印
 */
public class LogTest {

    @Test
    public void aroundAdviceLogTest() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("/springdemo2/resources/spring-config.xml");
        Person alex = (Person) atx.getBean("alex");
        alex.displayHobby("alex", "running");
    }
}
