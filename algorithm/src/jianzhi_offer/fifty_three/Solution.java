package jianzhi_offer.fifty_three;

import java.util.regex.*;

// 表示数值的字符串
// 正则表达式匹配
public class Solution {
    public boolean isNumeric(char[] str) {
        //待匹配的字符串line
        String line = String.valueOf(str);
        //正则表达式regex
        //分为符号位(0,1)，整数部分(0,多)，小数点(0,1)，小数部分(0,多)，指数部分(0,1)
        //符号位0次或1次[-\\+]?
        //整数部分1次\\d*，0个或多个整数
        //小数点0次或1次\\.?
        //小数部分同整数部分\\d*
        //指数部分，0次或1次([eE][-\\+]?\\d+)?
        //600.和-.123均返回true，所以整数和小数取\\d*而不是\\d+
        //String regex="[-\\+]?(\\d*\\.\\d*|\\d+)([eE][-\\+]?\\d+)?";
        String regex = "[-\\+]?(\\d*\\.?\\d*)([eE][-\\+]?\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        //匹配返回true，否则返回false
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
