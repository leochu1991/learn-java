package sort;

import java.util.*;

// 冒泡排序
// 稳定性：冒泡排序就是把小的元素往前调或者把大的元素往后调，比较时相同元素不发生交换，前后元素顺序不发生改变，是稳定的排序
// 时间复杂度：O(N*N)
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        //从arr[length-1]开始，每次将最大的数交换到最后
        for (int i = arr.length - 1; i > 0; i--) {
            //j从0到i-1，比较交换arr[j]和arr[j+1]
            for (int j = 0; j < i; j++) {
                //arr[j]>arr[j+1]，交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            //输出每趟排序后的数组
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 64, 51, 32, 21};
        int len = arr.length;
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("开始排序：");
        bubbleSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
