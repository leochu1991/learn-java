package behavioral_patterns.interpreter_pattern;

import org.junit.Test;

/**
 * interpreter pattern test
 * 举例: 正则表达式, sql解析, 浏览器解析页面
 */
public class InterpreterTest {
    @Test
    public void test() {
        TerminalExpression terminalExpression1 = new TerminalExpression("terminal1,terminal2,terminal3");
        TerminalExpression terminalExpression2 = new TerminalExpression("terminal4,terminal5,terminal6");

        OrExpression orExpression = new OrExpression(terminalExpression1, terminalExpression2);
        String context1 = "Terminal";
        System.out.printf("{[%s] || [%s]} contains [%s] is %b%n", terminalExpression1.getData(), terminalExpression2.getData(), context1, orExpression.interpret(context1));

        AndExpression andExpression = new AndExpression(terminalExpression1, terminalExpression2);
        String context2 = "terminal";
        System.out.printf("{[%s] && [%s]} contains [%s] is %b", terminalExpression1.getData(), terminalExpression2.getData(), context2, andExpression.interpret(context2));
    }
}
