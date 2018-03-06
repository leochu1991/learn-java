package jianzhi_offer.forty_nine;

// 把字符串转换成整数
public class Solution {
    //边界条件
    public int StrToInt(String str) {
        //str为null或者""，返回0
        if (str == null || str.length() < 1) {
            return 0;
        }
        //flag符号位，为1表示+，为-1表示-
        int flag = 1;
        //n表示str每个位置上的数字
        int n = 0;
        //begin表示从第几位计算，要除去符号位，为0表示没有符号位，为1表示有一个符号位，计算从第二位起
        int begin = 0;
        if (str.charAt(0) == '-') {
            //str长度为1，只有符号位，返回0
            if (str.length() == 1) {
                return 0;
            }
            //否则begin从1开始计算
            begin = 1;
            //负数
            flag = -1;
        }
        if (str.charAt(0) == '+') {
            //同上
            if (str.length() == 1) {
                return 0;
            }
            begin = 1;
            //正数
            flag = 1;
        }
        //从begin开始计算值，不包含最后一位，防止溢出
        for (int i = begin; i < str.length() - 1; i++) {
            //计算当前字符与'0'的差
            int tmp = str.charAt(i) - '0';
            //0~9数字
            if (tmp >= 0 && tmp <= 9) {
                n = (n + tmp) * 10;
            } else {
                //str中出现字符，返回0
                return 0;
            }
        }
        //n=n/10;加上最后一位个位数
        n = n + str.charAt(str.length() - 1) - '0';
        //flag为1返回n，否则返回-n
        return (flag == 1 ? n : -n);
    }
}
