package jianzhi_offer.forty_seven;

// 求1+2+3+...+n
public class Solution {
    public int Sum_Solution(int n) {
        //逻辑与短路实现递归终止
        int sum = n;
        //不能用if判断
        //if(n>0)
        //  sum+=Sum_Solution(n-1);
        //n==0时，返回0，否则返回n+Sum_Solution(n-1)
        boolean tmp = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
