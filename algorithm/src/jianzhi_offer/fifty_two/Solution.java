package jianzhi_offer.fifty_two;

// 正则表达式匹配
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        //字符串str，模式串pattern
        if (str == null || pattern == null) {
            return false;
        }
        //str和pattern的下标
        int strIndex = 0;
        int patIndex = 0;
        return matchCore(str, strIndex, pattern, patIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patIndex) {
        //字符串和模式串完全匹配
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        //字符串结束，模式串未结束
        if (strIndex < str.length && patIndex == pattern.length) {
            return false;
        }
        //模式串下一个字符为*
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            //当前字符串和模式串字符匹配或者模式串当前字符为.
            if (strIndex < str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
                //模式串当前字符出现0次，下次判断strIndex和patIndex+2
                boolean flag1 = matchCore(str, strIndex, pattern, patIndex + 2);
                //模式串当前字符出现1次，即模式串当前字符为.，匹配任意一个字符，下次判断strIndex+1和patIndex+2
                boolean flag2 = matchCore(str, strIndex + 1, pattern, patIndex + 2);
                //模式串当前字符出现2次及以上，下次判断strIndex+1和patIndex
                boolean flag3 = matchCore(str, strIndex + 1, pattern, patIndex);

                return flag1 || flag2 || flag3;
            } else {
                //否则模式串当前字符和字符串不匹配，模式串当前字符出现0次，判断strIndex和patIndex+2
                return matchCore(str, strIndex, pattern, patIndex + 2);
            }
        }
        //模式串下一个字符不为*，比较当前字符
        if (strIndex < str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
            //当前字符匹配或者模式串当前字符为.，继续比较下一个字符
            return matchCore(str, strIndex + 1, pattern, patIndex + 1);
        }
        //否则返回false
        return false;
    }
}
