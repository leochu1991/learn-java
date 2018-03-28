package behavioral_patterns.observer_pattern;

/**
 * 线程状态
 */
public enum StateEnum {
    NEW(0, "新建"),
    RUNNABLE(1, "可运行"),
    BLOCKED(2, "阻塞"),
    WAITING(3, "等待"),
    TIMED_WAITING(4, "限时等待"),
    TERMINATED(5, "终止");

    int value;
    String desc;

    StateEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
