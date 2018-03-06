package binary_search;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearchDemo {
    // 非递归
    private static int nonRecursiveBinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 递归
    private static int recursiveBinarySearch(int[] array, int low, int high, int target) {
        if (low <= high) {
            int mid = (low + high) >>> 1;
            if (array[mid] < target) {
                return recursiveBinarySearch(array, mid + 1, high, target);
            } else if (array[mid] > target) {
                return recursiveBinarySearch(array, low, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 7, 9, 4};
        int target = 4;
        Arrays.sort(array);
        int index = nonRecursiveBinarySearch(array, target);
        System.out.println(String.format("使用非递归方式是否找到目标数字：%d ？%s", target, index != -1 ? "是" : "否"));
        int index1 = recursiveBinarySearch(array, 0, array.length, target);
        System.out.println(String.format("使用递归方式是否找到目标数字：%d ？%s", target, index1 != -1 ? "是" : "否"));
    }
}
