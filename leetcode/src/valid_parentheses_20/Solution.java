package Valid_Parentheses;

import java.util.Stack;

//20. Valid Parentheses
//参考https://discuss.leetcode.com/topic/58178/1-ms-java-sol-using-stack/2
//和https://discuss.leetcode.com/topic/64334/java-solution-beats-98
public class Solution {
    public boolean isValid(String s) {
        //定义栈，若s.charAt(i)为'('，'['，'{'，则入栈
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            //其他情况若栈为空或者当前字符ch与栈顶字符不匹配，返回false
            if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        //返回栈是否为空，为空说明完全匹配，true，否则为false
        return stack.isEmpty();
    }
}
