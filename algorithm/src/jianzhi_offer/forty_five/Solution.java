package jianzhi_offer.forty_five;

import java.util.*;

// 扑克牌顺子
public class Solution {
    public boolean isContinuous(int[] numbers) {
        //numbers长度为0或者为null，返回false
        if (numbers.length == 0 || numbers == null) {
            return false;
        }
        //len：数组长度；zeros：数组中0的个数
        int len = numbers.length;
        int zeros = 0;
        for (int i = 0; i < len; i++) {
            //统计0的个数
            if (numbers[i] == 0) {
                zeros++;
            }
        }
        //排序，排序后0元素的下标为[0,zeros-1]
        Arrays.sort(numbers);
        //非0元素下标[zeros,len-1]
        int small = zeros;
        //small下一个元素
        int big = zeros + 1;
        //前后两个非0元素间距和
        int gap = 0;
        //big从zeros+1到len-1
        while (big < len) {
            //出现对子，返回false
            if (numbers[big] == numbers[small]) {
                return false;
            }
            //后一个数与前一个数的间距之和gap
            gap += numbers[big] - numbers[small] - 1;
            //向后移一位
            small = big;
            big++;
        }
        //间距之和小于等于非0元素个数返回true，否则返回false
        return gap <= zeros;
    }
}
