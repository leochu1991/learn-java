package jianzhi_offer.fifty_one;

// 构建乘积数组
// 动态规划，forward[i]表示前i个数A[0],A[1],A[2]...A[i-1]的的乘积
// backward[i]表示后i个数A[len-i],A[len-i+1]...A[len-1]的乘积
// B[i]=forward[i]*backward[len-1-(i+1)+1]
public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        //返回数组B
        int[] B = new int[len];
        int[] forward = new int[len];
        int[] backward = new int[len];
        forward[0] = 1;
        backward[0] = 1;
        //动态规划求forward和backward
        for (int i = 1; i < len; i++) {
            //i=1，forward[i]=A[0]；i=2，forward[i]=A[0]*A[1]，即A[1]*forward[i-1]
            forward[i] = A[i - 1] * forward[i - 1];
            //i=1，backward[i]=A[len-1]；i=2，backward[i]=A[len-2]*A[len-1]，即A[len-i]*backward[i-1]
            backward[i] = A[len - i] * backward[i - 1];
        }
        //求B[i]
        for (int i = 0; i < len; i++) {
            //B[i]表示前面0,1,...i-1共i个数的乘积A[0]*A[1]...A[i-1]，即forward[i]
            //和后面len-1-i个数的乘积A[i+1]*A[i+2]...*A[len-1]，即backward[len-1-i]
            //的乘积
            B[i] = forward[i] * backward[len - 1 - i];
        }
        //返回B
        return B;
    }
}
