package sort;

import java.util.*;

// 插入排序
// 由N-1趟排序组成，p=1到N-1，插入排序保证0到p上元素为已排序状态
// 时间复杂度O(N*N)，稳定
public class InsertionSort {
    public static void insertionSort(int[] arr, int left, int right) {
        //从left到p-1均为已排序状态
        for (int p = left + 1; p <= right; p++) {
            int tmp = arr[p];
            int j;
            //从后到前，将tmp插入到[left,p-1]之间j，arr[j-1]<=tmp&&arr[j]>tmp
            //tmp<arr[j-1]不能取=，不稳定
            for (j = p; j > left && (tmp < arr[j - 1]); j--) {
                //将比tmp大的值后移
                arr[j] = arr[j - 1];
            }
            //将tmp插入j
            arr[j] = tmp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 64, 51, 32, 21};
        int len = arr.length;
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("开始排序：");
        insertionSort(arr, 0, len - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
