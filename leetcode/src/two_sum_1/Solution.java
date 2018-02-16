package search_insert_position_35;

/**
 * 35. Search Insert Position
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid, index = -1;
        while (low <= high) {
            if (high == low) {
                if (nums[low] == target) {//nums[low]=target，查找到目标，返回low
                    index = low;
                    break;
                } else if (nums[low] < target) {//nums[low]<target，插入位置为low+1
                    index = low + 1;
                    break;
                } else {//nums[low]>target，插入位置为low
                    index = low;
                    break;
                }
            }
            //二分查找，通过中间位置mid判断
            mid = (high + low) / 2;
            if (nums[mid] == target) {//nums[mid]=target，返回mid
                index = mid;
                break;
            } else if (nums[mid] < target) {//nums[mid]<target，target在[mid+1,high]中
                low = mid + 1;
            } else {//nums[mid]>target，target在[low,mid]中
                high = mid;
            }
        }
        return index;
    }
}
