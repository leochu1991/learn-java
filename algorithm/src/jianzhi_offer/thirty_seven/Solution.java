package jianzhi_offer.thirty_seven;

// 数字在排序数组中出现的次数
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        //k未出现时返回0，所以初始化为0
        int count = 0;
        //array为null或长度<1，返回0
        if (array == null || array.length < 1) {
            return count;
        }
        //first：k第一次出现的下标
        //last：k第二次出现的下标
        int first = getFirstK(array, 0, array.length - 1, k);
        int last = getLastK(array, 0, array.length - 1, k);
        //first，last!=1表示下标存在，计算次数
        if (first != -1 && last != -1) {
            count = last - first + 1;
        }
        return count;
    }

    // 排序数组，二分查找，递归查找第一个k的下标
    public int getFirstK(int[] array, int first, int end, int k) {
        // first>end表示未找到，返回-1
        if (first > end) {
            return -1;
        }

        int mid = (first + end) / 2;
        if (array[mid] == k) {
            //mid不是0，且前一个元素不为k，或者mid为0时first即为mid，返回mid
            if (mid > 0 && array[mid - 1] != k || mid == 0) {
                return mid;
            }//否则前一个元素仍为k，first在左半部分中，end=mid-1
            else {
                end = mid - 1;
            }
        }
        //first在左半部分中，end=mid-1
        else if (array[mid] > k) {
            end = mid - 1;
        }//first在右半部分中，first=mid+1
        else {
            first = mid + 1;
        }
        //递归查找first    
        return getFirstK(array, first, end, k);
    }

    //二分查找，递归查找最后一个k的下标
    public int getLastK(int[] array, int first, int end, int k) {
        //first>end表示未找到，返回-1
        if (first > end) {
            return -1;
        }

        int mid = (first + end) / 2;
        if (array[mid] == k) {
            //mid不是最后一个元素，且下一个元素不为k，或者mid为最后一个元素时，last即为mid，返回mid
            if (mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1) {
                return mid;
            }//否则后一个元素仍为k，last在右半部分中，first=mid+1
            else {
                first = mid + 1;
            }
        }
        //last在右半部分中，first=mid+1
        else if (array[mid] < k) {
            first = mid + 1;
        }//last在左半部分中，end=mid-1
        else {
            end = mid - 1;
        }
        //递归查找last   
        return getLastK(array, first, end, k);
    }
}
