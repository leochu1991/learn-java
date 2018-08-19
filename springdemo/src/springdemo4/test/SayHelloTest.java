package springdemo4.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import springdemo4.bean.Person;

/**
 * test
 */
public class SayHelloTest {
    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("springdemo4/resources/spring-config.xml"));
        // 需无参构造器
        Person person = (Person) beanFactory.getBean("person");
        person.setName("zhangsan");
        person.setAge(22);
        person.sayHello();
    }
}
