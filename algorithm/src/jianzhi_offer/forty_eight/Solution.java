package jianzhi_offer.forty_eight;

// 不用加减乘除做加法
public class Solution {
    // 递归
    public int recursiveAdd(int num1, int num2) {
        //递归出口，num1表示两个数的和，不考虑进位，num2表示有进位，直到num2为0时递归结束
        if (num2 == 0) {
            return num1;
        }
        //num1^num2表示不考虑进位时两个数的和，num1&num2表示哪些位有进位，然后左移一位，直至进位为0
        return recursiveAdd(num1 ^ num2, (num1 & num2) << 1);
    }

    // 非递归
    public int nonRecursiveAdd(int num1, int num2) {
        while (num2 != 0) {
            int n1 = num1 ^ num2;
            int n2 = (num1 & num2) << 1;
            num1 = n1;
            num2 = n2;
        }
        return num1;
    }
}
