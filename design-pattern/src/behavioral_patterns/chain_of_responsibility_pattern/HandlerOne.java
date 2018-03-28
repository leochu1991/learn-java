package behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 请求处理者一
 */
public class HandlerOne implements Handler {
    // 处理者名字
    private String name;
    // 下一个处理者的引用
    private Handler nextHandler;

    public HandlerOne(String name) {
        this.name = name;
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void dealRequest(Request request) {
        if (request.getRequestType().equals("PayRise") && request.getNumber() < 1000) {
            System.out.println(String.format("===pay rise: %d agreed by %s===", request.getNumber(), name));
        } else {
            if (nextHandler != null) {
                nextHandler.dealRequest(request);
            }
        }
    }
}
