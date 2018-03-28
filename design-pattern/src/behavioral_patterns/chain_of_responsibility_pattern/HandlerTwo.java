package behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 请求处理者二
 */
public class HandlerTwo implements Handler {
    // 处理者名字
    private String name;
    // 下一个处理者的引用
    private Handler nextHandler;

    public HandlerTwo(String name) {
        this.name = name;
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void dealRequest(Request request) {
        if (request.getRequestType().equals("SickLeave") && request.getNumber() < 3) {
            System.out.println(String.format("===sick leave: %d days agreed by %s===", request.getNumber(), name));
        } else {
            if (nextHandler != null) {
                nextHandler.dealRequest(request);
            }
        }
    }
}
