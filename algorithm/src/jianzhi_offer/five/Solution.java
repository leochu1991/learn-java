package jianzhi_offer.five;

//用两个栈实现队列

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // Stack继承自Vector，有empty(),peek(),pop(),push(E item),search(Object o)等方法，后进先出（LIFO）
    // 入队，元素加在队尾，和栈的push相同
    public void push(int node) {
        // 栈的push方法入栈，在队尾，和队列相同
        stack1.push(node);
    }

    // 出队，头先出列，即stack1的栈底元素
    public int pop() {
        // stack1不为empty，则将stack1元素加入到stack2中
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        // 要出列的元素为stack2的栈顶元素
        int head = stack2.pop();
        // 将stack2剩下的元素全部压入stack1
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return head;
    }
}
