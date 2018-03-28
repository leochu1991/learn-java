package behavioral_patterns.mediator_pattern;

/**
 * 对象类接口
 */
public interface Colleague {
    // 发送消息
    void sendMessage(String message);

    // 接受消息
    void onMessage(String message);
}
