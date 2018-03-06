package jianzhi_offer.forty_one;

import java.util.ArrayList;

// 和为S的连续正数序列
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        //最小的两个数字是1和2，小于3则返回pathlist
        if (sum < 3) {
            return pathlist;
        }

        int small = 1;
        int big = 2;
        //mid=(small+big)/2
        int mid = (1 + sum) >> 1;
        int cursum = small + big;
        //直到small小于(1+sum)/2，最少两个数字，path中元素有序，small最大为(sum-1)/2
        while (small < mid) {
            //当前和cursum=sum时，添加path到pathlist
            if (cursum == sum) {
                path = addPath(small, big);
                pathlist.add(path);
            }
            //要有small<mid，sum至少为两个数之和
            while (cursum > sum && small < mid) {
                //增加small
                cursum -= small;
                small++;
                if (cursum == sum) {
                    path = addPath(small, big);
                    pathlist.add(path);
                }
            }
            //cursum<sum时，增加big，cursum
            big++;
            cursum += big;
        }
        return pathlist;
    }

    //将[small,big]内的元素添加到path
    public ArrayList<Integer> addPath(int small, int big) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            path.add(i);
        }
        return path;
    }
}
