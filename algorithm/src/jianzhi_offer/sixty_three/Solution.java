package jianzhi_offer.sixty_three;

import java.util.*;

// 数据流中的中位数
// 为保证插入时间为logn，获得中位数时间为1，使用最大堆和最小堆的容器
// 且左右容器元素个数相差不超过1；最大堆所有元素小于最小堆元素
public class Solution {
    //根据优先队列构造最小堆，默认自然排序
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    //传入比较器Comparator，构造最大堆，初始容量11
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        //重写compare方法
        public int compare(Integer o1, Integer o2) {
            //默认最小堆，反转默认排序器，实现最大堆
            return o2.compareTo(o1);
        }
    });

    //数据总数为偶数时，新数据添加到最小堆minHeap中，否则添加到最大堆maxHeap中
    public void Insert(Integer num) {
        int size = maxHeap.size() + minHeap.size();
        //队列总元素个数为偶数，新插入的元素加到最小堆
        if ((size & 1) == 0) {
            //若新插入元素小于最大堆中元素，将新元素插入到最大堆中，再将最大堆中的最大元素插入到最小堆
            //isEmpty()防止空指针异常
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                //将num添加到最大堆
                maxHeap.add(num);
                //弹出最大堆中的最大元素，添加到最小堆
                minHeap.add(maxHeap.poll());
            } else {
                //num比最大堆中所有元素都大，直接添加到最小堆
                minHeap.add(num);
            }
        } else {
            //否则将新元素添加到最大堆
            //若新添加元素大于最小堆中的元素，将num添加到最小堆，再将最小堆中的最小元素插入到最大堆
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                //将num添加到最小堆
                minHeap.add(num);
                //弹出最大堆中的最小元素，添加到最大堆
                maxHeap.add(minHeap.poll());
            } else {
                //num比最小堆中所有元素都小，直接添加到最大堆
                maxHeap.add(num);
            }
        }
    }

    //数据总数为偶数时，新数据添加到最小堆minHeap中，否则添加到最大堆maxHeap中
    public Double GetMedian() {
        int size = maxHeap.size() + minHeap.size();
        double median = 0;
        //数据元素个数为奇数，返回最小堆中最小元素，即队列头元素
        if ((size & 1) == 1) {
            median = minHeap.peek();
        } else {
            //否则返回最大堆和最小堆头元素的平均值，注意：/2.0，不是2
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return median;
    }
}
