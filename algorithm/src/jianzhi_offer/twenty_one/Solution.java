package jianzhi_offer.twenty_one;

import java.util.*;

// 栈的压入，弹出序列
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        //入栈，出栈长度为0，返回false
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        //popInx表示弹出序列
        int popInx = 0;
        for (int i = 0; i < pushA.length; i++) {
            //依次将元素入栈
            stack.push(pushA[i]);
            //popInx不会越界，有!stack.empty()，栈中元素个数小于等于popA中个数
            //栈不为null，弹出元素和入栈元素相等，元素出栈，不相等则继续入栈
            while (!stack.empty() && stack.peek() == popA[popInx]) {
                stack.pop();
                popInx++;
            }
        }
        //返回stack是否为null，为null说明是弹出序列
        return stack.empty();
    }
}
