package jianzhi_offer.twelve;

//数值的整数次方
public class Solution {
    public double power(double base, int exponent) {
        double b = base;
        int flag = 0;
        //指数为负数，flag=1，返回1/b
        if (exponent < 0) {
            flag = 1;
            exponent = -exponent;
        }
        //指数为0，返回1
        if (exponent == 0) {
            return 1;
        }
        //指数为正数，因为b=base,所以执行次数exponent-1次
        while (exponent > 1) {
            b = b * base;
            exponent--;
        }
        //指数为负数
        if (flag > 0) {
            //底数为0，返回0，否则返回1/b
            if (base - 0.0 > -0.000001 && base - 0.0 < 0.000001) {
                return 0;
            }
            return 1 / b;
        }
        return b;
    }
}
