package jianzhi_offer.seven;

//斐波那契数列
public class Solution {
    public int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int num1 = 0, num2 = 1, curnum = 1;
        for (int i = 2; i <= n; i++) {
            curnum = num1 + num2;
            num1 = num2;
            num2 = curnum;
        }
        return curnum;
    }

    public int fibonacci2(int n) {
        int first = 0, second = 1;
        while (n > 0) {
            second = first + second;
            first = second - first;
            n--;
        }
        return first;
    }
}
