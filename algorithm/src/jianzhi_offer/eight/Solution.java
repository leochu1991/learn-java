package jianzhi_offer.eight;

//跳台阶
public class Solution {
    public int JumpFloor(int target) {
        //递归。target=1，一种方法，target=2，先跳一级，再跳一级；直接跳两级，共有两种方法，所以return target
        if (target == 1 || target == 2) {
            return target;
        } else {
            //否则若第一次跳一级，则剩下n-1级，有f(n-1)种方法；第一次跳两级，剩下n-2级，有f(n-2)种方法。总共有f(n-1)+f(n-2)方法
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
