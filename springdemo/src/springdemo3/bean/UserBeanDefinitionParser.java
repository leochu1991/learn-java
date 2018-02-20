package springdemo3.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 自定义标签解析类，回调doParse方法解析
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    // 返回User类
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    // 自定义解析User类
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        // 获取User类的成员变量
        String id = element.getAttribute("id");
        String username = element.getAttribute("username");
        String sex = element.getAttribute("sex");
        String age = element.getAttribute("age");
        // 将element中非空的属性添加到beanDefinitionBuilder中，然后添加到beanFactory
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(username)) {
            builder.addPropertyValue("username", username);
        }
        if (StringUtils.hasText(sex)) {
            builder.addPropertyValue("sex", sex);
        }
        if (StringUtils.hasText(age)) {
            builder.addPropertyValue("age", age);
        }
    }
}
