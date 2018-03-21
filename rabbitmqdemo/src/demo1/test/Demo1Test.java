package demo1.test;

import demo1.service.MessageProducer;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * rabbitmq test
 */
public class Demo1Test {
    // private static final Logger logger = Logger.getLogger("WARN");
    private static final Logger logger = Logger.getLogger(Demo1Test.class);
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        // 用spring管理，不能用 MessageProducer messageProducer = new MessageProducer(); 否则不能注入 amqpTemplate
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
    }

    @Test
    public void test1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exchange", "demo1Exchange");
        jsonObject.put("routingKey", "demo1MessageQueueKey");
        jsonObject.put("queue", "demo1MessageQueue");
        JSONObject message = new JSONObject();
        message.put("producer", "admin");
        message.put("itemCount", 100);
        jsonObject.put("message", message);

        logger.warn("======do not create bean with new, use Spring ApplicationContext, or you won't get amqpTemplate======");

        MessageProducer messageProducer = applicationContext.getBean(MessageProducer.class);
        for (int i = 0; i < 10; i++) {
            jsonObject.getJSONObject("message").put("id", i + 1);
            messageProducer.setMessage(jsonObject);
            messageProducer.sendMessage(jsonObject);
        }
    }
}
