package sort;

import java.util.*;

// 基数排序
// 稳定性：稳定
// 时间复杂度：O(p*(N+b))，其中p是趟数（每个元素共有几位，个，十，百。。），N是待排元素的个数，b是桶的个数（十进制数则0到9共10个，每趟不固定）
public class RadixSort {
    //radix表示进制，divide表示每个元素最多有多少位
    public static void radixSort(int[] arr, int radix, int divide) {
        //r表示进制位，初始为1
        int r = 1;
        //d表示当前为第几位，初始为1
        int d = 1;
        //k表示arr的下标
        int k = 0;
        //二维数组tmp[i][]表示当前位为i时的arr元素，最多有arr.length个
        int[][] tmp = new int[radix][arr.length];
        //order[i]表示当前位为i的个数，初始为0
        int[] order = new int[radix];
        Arrays.fill(order, 0);
        //从低位开始对arr元素的每一位进行排序
        while (d <= divide) {
            //求每个元素的当前位
            for (int i = 0; i < arr.length; i++) {
                //最低位lsb
                int lsb = (arr[i] / r) % radix;
                tmp[lsb][order[lsb]] = arr[i];
                //order[lsb]个数++
                order[lsb]++;
            }
            //根据order对arr重新排序
            for (int i = 0; i < radix; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = tmp[i][j];
                        k++;
                    }
                }
                //order[i]归零
                order[i] = 0;
            }
            //更新r，个位变十位。。。
            r = r * radix;
            //k归零，d++
            k = 0;
            d++;
            //输出每趟排序结果
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {73, 22, 93, 867494, 43, 55, 123, 8978, 10000, 14, 28, 65, 39, 81, 33, 100, 567};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("开始排序：");
        radixSort(arr, 10, 6);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
