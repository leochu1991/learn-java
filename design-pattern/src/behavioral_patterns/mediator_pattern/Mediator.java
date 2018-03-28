package behavioral_patterns.mediator_pattern;

/**
 * 中介者接口
 */
public interface Mediator {
    void sendMessage(Colleague colleague, String message);
}
