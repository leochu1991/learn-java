package jianzhi_offer.six;

// 旋转数组的最小数字

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        // 数组大小为0，则返回0
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        // array[start]>=array[end]确保数组旋转，未旋转返回array[start],也是array[mid]
        while (array[start] >= array[end]) {
            // 出口，最小的数array[end]在最大数array[end]之后
            if (end - start == 1) {
                mid = end;
                break;
            }
            // 二分查找
            mid = (start + end) / 2;
            // 无法确定中间数array[mid]是在前面递增子数组还是后面递增子数组，只能顺序查找最小值，返回array[index]
            if (array[start] == array[mid] && array[end] == array[mid]) {
                int index = start;
                for (int i = start + 1; i <= end; i++) {
                    if (array[i] < array[index]) {
                        index = i;
                    }
                }
                return array[index];
            }
            // <=表示中间数array[mid]在后面递增子数组中，最小值在[start,mid]中
            if (array[mid] <= array[end]) {
                end = mid;
            }
            // 否则array[mid]>array[end]，表示array[mid]在前面递增子数组中，最小值在[mid,end]中
            else {
                start = mid;
            }
        }
        return array[mid];
    }
}
