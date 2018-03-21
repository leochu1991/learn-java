package demo1.service;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 消息生产者
 */
@Service("messageProducer")
public class MessageProducer {
    private static final Logger logger = Logger.getLogger(MessageProducer.class);
    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    private String exchange;
    private String routingKey;
    private String queue;
    private JSONObject message;

    /**
     * 设置消息参数
     *
     * @param jsonObject
     */
    public void setMessage(JSONObject jsonObject) {
        this.exchange = jsonObject.getString("exchange");
        this.routingKey = jsonObject.getString("routingKey");
        this.queue = jsonObject.getString("queue");
        this.message = jsonObject.getJSONObject("message");
    }

    /**
     * 发送消息
     *
     * @param jsonObject
     */
    public void sendMessage(JSONObject jsonObject) {
        logger.info(String.format("======Thread is sending message====== currentThread: %s, exchange: %s, routingKey: %s, queue: %s, message: %s",
                Thread.currentThread().getName(), exchange, routingKey, queue, message.toString()));
        try {
            amqpTemplate.convertAndSend(jsonObject.toString());
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (AmqpException e) {
            logger.warn(String.format("message fails to send, message: %s, exception detail: %s", message.toString(), e.getMessage()));
        } catch (InterruptedException e) {
            logger.warn(String.format("occurs InterruptedException, exception detail: %s", e.getMessage()));
        }
    }
}
