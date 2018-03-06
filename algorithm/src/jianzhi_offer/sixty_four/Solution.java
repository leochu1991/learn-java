package jianzhi_offer.sixty_four;

import java.util.*;

// 滑动窗口的最大值
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //index表示滑动窗口中的下标，符合先进先出
        //index的第一个元素index.getFirst()中存放的是滑动窗口的最大元素的下标
        ArrayDeque<Integer> index = new ArrayDeque<Integer>();
        for (int i = 0; i < num.length; i++) {
            //若双端队列不为空，且back元素小于新添加元素num[i]，移除back元素
            while (!index.isEmpty() && num[index.getLast()] < num[i]) {
                index.removeLast();
            }
            //若双端队列不为空，且front元素和新添加元素num[i]间距超过size，移除front
            while (!index.isEmpty() && (i - index.getFirst() + 1) > size) {
                index.removeFirst();
            }
            //将下标i添加到index
            index.addLast(i);
            //若size大于0且i+1>=size时，向res中添加新元素num[index.getFirst()]
            if (size > 0 && (i + 1) >= size) {
                res.add(num[index.getFirst()]);
            }
        }
        //返回res
        return res;
    }
}
