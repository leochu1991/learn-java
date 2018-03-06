package jianzhi_offer.ten;

//矩形覆盖
public class Solution {
    private int rectCover(int target) {
        //target=0,没有，返回0；target=1,一种方法；target=2，两个小矩形横着放和竖着放，两种方法
        if (target == 0 || target == 1 || target == 2) {
            return target;
        } else {
            //否则，第一次一个小矩形竖着放，剩下RectCover(target-1)种方法；第一次两个小矩形横着放，剩下RectCover(target-2)种方法，递归
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}
