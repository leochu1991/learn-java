package two_sum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.Two Sum
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 将<nums[i],i>存入map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            // nums[i]不在map中，与minus下标不一致
            if (map.containsKey(minus)) {
                // map中存在minus与nums[i]的和等于target，返回下标
                return new int[]{map.get(minus), i};
            }
            // 否则将<nums[i],i>存入map
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
