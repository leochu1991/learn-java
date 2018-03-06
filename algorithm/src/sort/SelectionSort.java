package sort;

import java.util.*;

// 选择排序
// 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
// 时间复杂度：O(N*N)
// 稳定性：选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）
public class SelectionSort{
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                //arr[j]<arr[minIndex]，minIndex=j
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //若minIndex!=i，交换arr[i]和arr[minIndex]
            if(minIndex!=i){
                int tmp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=tmp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args){
        int[] arr={34,8,64,51,32,21};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("开始排序：");
        selectionSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
