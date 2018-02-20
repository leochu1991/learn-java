package springdemo3.bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义标签处理器
 */
public class UserNamespaceHandlerSupport extends NamespaceHandlerSupport {
    @Override
    public void init() {
        // 将(localName, UserBeanDefinitionParser)注册到registerBeanDefinitionParser
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
