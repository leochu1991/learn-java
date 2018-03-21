package demo1.service;

import com.rabbitmq.client.Channel;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 */
@Service("messageConsumer")
public class MessageConsumer implements ChannelAwareMessageListener {
    private static Logger logger = Logger.getLogger(MessageConsumer.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        JSONObject jsonObject = new JSONObject(new String(message.getBody(), "UTF-8"));
        logger.info(String.format("======queue : %s receives message====== : %s",
                jsonObject.get("queue"), jsonObject.get("message")));
        try {
            // 确认当前消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
