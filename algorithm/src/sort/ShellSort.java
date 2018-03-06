package sort;

import java.util.*;

// 希尔排序，也叫缩减增量排序，实质就是分组插入排序
// 该方法的基本思想是：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
// 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
// 因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。

// 稳定性：由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，但在不同的插入排序过程中，
// 相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以shell排序是不稳定的
// 时间复杂度：N的1.3次幂
public class ShellSort {
    public static void shellSort(int[] arr) {
        //分组插入排序
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            int j;
            //从gap位置开始
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                //j>=gap，防止下标越界
                for (j = i; j >= gap && (tmp < arr[j - gap]); j = j - gap) {
                    //直接插入排序，将arr[j-gap]右移至arr[j]
                    arr[j] = arr[j - gap];
                }
                //插入arr[j]
                arr[j] = tmp;
            }
            System.out.println("gap=" + gap + "排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 64, 51, 32, 21};
        int len = arr.length;
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("开始排序：");
        shellSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
