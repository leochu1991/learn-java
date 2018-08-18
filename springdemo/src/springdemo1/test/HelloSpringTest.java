package springdemo1.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo1.bean.HelloSpring;
import springdemo1.bean.HelloSpring1;
import springdemo1.bean.HelloSpring2;

/**
 * 获取bean的实例
 */
public class HelloSpringTest {
    @Test
    public void testSayHello() {
        // configLocation默认classpath，可以写作classpath:/springdemo1/...;classpath:springdemo1/...;springdemo1/resources/...
        ApplicationContext atx = new ClassPathXmlApplicationContext("/springdemo1/resources/spring-config.xml");
        HelloSpring helloSpring = (HelloSpring) atx.getBean("HelloSpring");
        System.out.println(helloSpring.sayHello());
    }

    @Test
    public void testSayHello1() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("/springdemo1/resources/spring-config1.xml");
        //byType
        HelloSpring1 helloSpring = atx.getBean(HelloSpring1.class);
        System.out.println(helloSpring.sayHello());
    }

    @Test
    public void testSayHello2() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("/springdemo1/resources/spring-config2.xml");
        //byName需要@Component("helloSpringNew2")指定名称
        HelloSpring2 helloSpring = (HelloSpring2) atx.getBean("helloSpring2");
        System.out.println(helloSpring.sayHello());
    }
}
