package behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 请求对象
 */
public class Request {
    private String requestType;
    private int number;

    public Request(String requestType, int number) {
        this.requestType = requestType;
        this.number = number;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType='" + requestType + '\'' +
                ", number=" + number +
                '}';
    }
}
