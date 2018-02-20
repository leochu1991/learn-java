package find_k_pairs_with_smallest_sums_373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * 参考https://discuss.leetcode.com/topic/50529/java-9ms-heap-queue-solution-k-log-k/5
 */
public class Solution {
    //nums1[i]和nums2[j]组成的pair
    class Pair {
        int i, j;
        int[] nums1, nums2;

        public Pair(int i, int j, int[] nums1, int[] nums2) {
            this.i = i;
            this.j = j;
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        public int sum() {
            return nums1[i] + nums2[j];
        }
    }

    //自定义比较器
    class MyPairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.sum() - p2.sum();
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        //定义优先队列，队首元素和最小
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new MyPairComparator());
        //先将nums1[i]和nums2[0]组成的n1个pair添加到pq，n1=Math.min(nums1.length,k)
        for (int i = 0; i < Math.min(len1, k); i++) {
            pq.offer(new Pair(i, 0, nums1, nums2));
        }
        //取pq中前k个sum和
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            //取队首元素加入res
            Pair p = pq.poll();
            res.add(new int[]{nums1[p.i], nums2[p.j]});
            //若p.j<len2-1，将nums1[p.i],nums2[++p.j]组成的pair加入pq
            if (p.j < len2 - 1) {
                //下一个元素从pq和new int[]{nums1[p.i],nums2[++p.j]中产生
                int next = ++p.j;
                pq.offer(new Pair(p.i, next, nums1, nums2));
            }
        }
        //返回res
        return res;
    }
}
