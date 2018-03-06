package jianzhi_offer.forty_six;

import java.util.LinkedList;

// 孩子们的游戏(圆圈中最后剩下的数)
public class Solution {
    // 循环队列LinkedList，时间复杂度为O(nm)
    public int LastRemaining_Solution1(int n, int m) {
        //边界条件
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        //将数字加入循环队列
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //current表示当前索引
        int current = 0;
        //每次remove元素，直到list中只剩一个元素
        while (list.size() > 1) {
            //int size=list.size();
            //当前在current，每次前进m后的索引为(current+m-1)%size
            //若用list.size();remove后list.size()已经减小1，但current未改变，所以用size
            //list.remove((current+m-1)%size);
            //current不等于(current+m-1)%size+1，即不用加1
            //LinkedList中remove(index)方法表示移除此列表中指定位置处的元素。将任何后续元素向左移（从索引中减 1）。返回从列表中删除的元素。
            //current=(current+m-1)%size;

            //或者先计算当前需要remove的索引current
            current = (current + m - 1) % list.size();
            //remove当前current元素，后续元素左移
            list.remove(current);
        }
        //返回最后一个元素
        return list.remove(0);
    }

    // 约瑟夫环问题；最后返回值为f(n,m) n=1，返回0；n>1，返回(f(n-1,m)+m)%n 递归
    public int LastRemaining_Solution2(int n, int m) {
        //边界条件
        if (n < 1 || m < 1) {
            return -1;
        }

        if (n == 1) {
            return 0;
        } else {
            return (LastRemaining_Solution2(n - 1, m) + m) % n;
        }
    }
}
