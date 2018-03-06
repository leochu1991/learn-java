package jianzhi_offer.forty_three;

// 左旋转字符串
// 三步翻转，翻转左半部分[0,n-1]，翻转右半部分[n,len-1],翻转全部[0.len-1]
public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        //str长度
        int len = str.length();
        //循环移位取模，n表示substring的beginIndex
        n = n % len;
        //两个str拼接起来
        str = str + str;
        //substring(int beginIndex, int endIndex) 
        return str.substring(n, len + n);
    }
}
