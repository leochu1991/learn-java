package sort;

import java.util.*;

// 快速排序
// 枢纽元pivot不用三数中值分割法（交换直到left<center<right，交换center和right-1，返回right-1(pivot)，确保left<pivot<right）
// 直接选取right位置元素作为枢纽
// 时间复杂度O(N*logN)，不稳定
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        //left<right排序，防止越界
        if (left < right) {
            //pivot=arr[right];
            int pivot = arr[right];
            int begin = left;
            int end = right - 1;
            while (begin < end) {
                //从左到右找到比pivot大的元素
                while (arr[begin] < pivot)
                    begin++;
                //从右往左找到比pivot小的元素
                while (arr[end] > pivot)
                    end--;
                //若begin<end，交换
                if (begin < end) {
                    swap(arr, begin, end);
                } else {
                    break;
                }
            }
            //交换arr[begin]和枢纽元pivot，即arr[right]
            swap(arr, begin, right);
            //左右递归
            quickSort(arr, left, begin - 1);
            quickSort(arr, begin + 1, right);
        }
    }

    //交换arr[i]和arr[j]
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 64, 51, 32, 21};
        int len = arr.length;
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, len - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
