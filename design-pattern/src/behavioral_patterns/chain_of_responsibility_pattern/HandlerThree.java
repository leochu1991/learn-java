package behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 请求处理者三
 */
public class HandlerThree implements Handler {
    // 处理者名字
    private String name;
    // 下一个处理者的引用
    private Handler nextHandler;

    public HandlerThree(String name) {
        this.name = name;
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void dealRequest(Request request) {
        if (request.getRequestType().equals("SickLeave")) {
            System.out.println(String.format("===sick leave: %d days agreed by %s===", request.getNumber(), name));
        } else if (request.getRequestType().equals("PayRise") && request.getNumber() < 3000) {
            System.out.println(String.format("===pay rise: %d agreed by %s===", request.getNumber(), name));
        } else {
            System.out.println(String.format("===pay rise: %d NOT agreed by %s===", request.getNumber(), name));
        }
    }
}
