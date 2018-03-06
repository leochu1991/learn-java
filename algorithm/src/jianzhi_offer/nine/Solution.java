package jianzhi_offer.nine;

//变态跳台阶
public class Solution {
    public int JumpFloorII(int target) {
        //0级或1级台阶时只有一种方法
        if (target == 0 || target == 1) {
            return 1;
        } else {
            //target>=2时，分为第一次跳1级，剩下f(target-1)种方法；第一次跳2级，剩下f(target-2)种方法。。。第一次跳target级，剩下f(0)种方法
            //f(target)=f(target-1)+f(target-2)+...+f(1)+f(0)，递归求解
            int sum = 0;
            while (target >= 0) {
                sum = sum + JumpFloorII(target - 1);
                target--;
            }
            return sum;
        }
    }
}
