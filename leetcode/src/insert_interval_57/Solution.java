package insert_interval_57;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * 57.Insert Interval
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ListIterator<Interval> iter = intervals.listIterator();
        //自定义比较器
        Comparator<Interval> myComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        //新插入区间的边界
        int left = newInterval.start;
        int right = newInterval.end;

        while (iter.hasNext()) {
            //区间中的每个元素it
            Interval it = iter.next();
            if (right < it.start) {
                //新元素在所有区间之前，直接添加到最开始处，并返回
                iter.previous();
                //注意使用new
                intervals.add(new Interval(left, right));
                //排序
                Collections.sort(intervals, myComparator);
                return intervals;
            } else if (it.end < left) {
                //没有重叠部分
                continue;
            } else {
                //新区间与it有重叠部分，重新合并新区间，并删除it
                left = Math.min(left, it.start);
                right = Math.max(right, it.end);
                iter.remove();
            }
        }
        //将合并后的新区间添加到intervals
        intervals.add(new Interval(left, right));
        //排序
        Collections.sort(intervals, myComparator);
        return intervals;
    }
}
