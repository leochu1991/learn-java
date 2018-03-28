package behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 处理请求的对象接口
 */
public interface Handler {
    // 设置下一个处理者
    void setNextHandler(Handler handler);

    // 处理请求
    void dealRequest(Request request);
}
