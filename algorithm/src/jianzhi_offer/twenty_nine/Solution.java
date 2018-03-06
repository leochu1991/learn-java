package jianzhi_offer.twenty_nine;

import java.util.ArrayList;

//最小的K个数

//冒泡排序；最小堆
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //n<k，返回[]
        if (input.length < k) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            //最小堆排序，取出前k个最小数，循环k次，每次数组排序长度减1
            int mini = heapSort(input, input.length - 1 - i);
            list.add(mini);
        }
        return list;
    }

    private int heapSort(int[] input, int size) {
        //size=0时，输出所有数(k=n)，此时input[0]为最小值，其余数均已排序，返回
        if (size == 0) {
            return input[0];
        }
        //父节点(size-1)/2
        //循环建最小堆，每次循环后父节点都是最小堆，循环(size-1)/2+1次(从当前父节点到堆顶0)，此时堆顶元素为当前堆中的最小值
        for (int i = (size - 1) / 2; i >= 0; i--) {
            //循环建堆的次数不变，将i赋值给k
            int k = i;
            while (2 * k + 1 <= size) {
                //左节点2*k+1
                int j = 2 * k + 1;
                //判断是否有右节点
                if (j < size) {
                    int index = j + 1;
                    //若右节点小于左节点，j变成右节点
                    if (input[index] < input[j]) {
                        j = index;
                    }
                }
                //子节点大于父节点，满足最小堆，子节点的子树已经满足最小堆，跳出
                if (input[j] > input[k]) {
                    break;
                }
                //子节点小于父节点，交换
                int tmp = input[k];
                input[k] = input[j];
                input[j] = tmp;
                //while循环进行堆调整，直到j节点的所有子树均满足最小堆
                k = j;
            }

        }
        //将堆顶和size处的元素交换
        int tmp = input[0];
        input[0] = input[size];
        input[size] = tmp;
        //input[size]为当前数组中的最小值，返回
        return input[size];
    }
}
