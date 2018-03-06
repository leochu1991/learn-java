package jianzhi_offer.eleven;

//二进制中1的个数
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        //直接将n和2取模，效率较低
        //将1循环左移，再和n取与，得到n的每个位置上是否有1
        //若将n循环右移，则n为负数时，移位若干次后得到FFFFFFF，陷入死循环
        //也可以将n=n&(n-1);count++;每次去掉n中最右边的1
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
