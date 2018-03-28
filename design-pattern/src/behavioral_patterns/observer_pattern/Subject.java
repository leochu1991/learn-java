package behavioral_patterns.observer_pattern;

/**
 * 主题接口
 */
public interface Subject {
    // 增加观察者
    void attach(Observer observer);
    // 移除观察者
    void detach(Observer observer);
    // 设置状态
    void setState(String state);
    // 获得状态
    String getState();
    // 通知所有观察者
    void notifyObservers();
}
