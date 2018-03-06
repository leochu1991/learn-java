package jianzhi_offer.twenty;

import java.util.Stack;

//包含min函数的栈
public class Solution {
    //datastack放所有进栈数据，minstack放进栈的递减数据，即进栈数据比minstack.peek()小才进栈
    Stack<Integer> datastack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public void push(int node) {

        //datastack中数据全部进栈
        datastack.push(node);
        //minstack为空，（不是null，用empty()判断），数据进栈
        if (minstack.empty()) {
            minstack.push(node);
        }
        //否则minstack只入栈比栈顶值小的数据
        else {
            if (node <= minstack.peek()) {
                minstack.push(node);
            }
        }
    }

    //datastack中数据依次出栈，如果出栈数据num==minstack栈顶元素，则minstack元素也要出栈
    public void pop() {
        int num = datastack.pop();
        if (num == minstack.peek())
            minstack.pop();
    }

    //返回datastack栈顶数据
    public int top() {
        return datastack.peek();
    }

    //栈最小元素即为minstack栈顶元素
    public int min() {
        return minstack.peek();
    }
}
