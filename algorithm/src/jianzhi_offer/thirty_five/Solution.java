package jianzhi_offer.thirty_five;

// 数组中的逆序对
// 采用类似冒泡排序算法，时间复杂度O(n^2)，类似归并排序算法时间复杂度O(nlogn)
public class Solution {
    int count = 0;

    public int InversePairs(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        //辅助数组tmp
        int[] tmp = new int[array.length];

        mergeSort(array, 0, array.length - 1, tmp);
        return count;
    }

    //归
    public void mergeSort(int[] array, int start, int end, int[] tmp) {
        //递归分解，直到只有两个数字
        if (start < end) {
            int mid = (start + end) / 2;
            //左边序列[start,mid]，要有序，计算次数count时需要有序数组来判断左边序列有多少个a[i]>a[j]
            mergeSort(array, start, mid, tmp);
            //右边序列[mid+1,end]，要有序
            mergeSort(array, mid + 1, end, tmp);
            //合并左右有序序列
            merge(array, start, mid, end, tmp);
        }
    }

    //并
    public void merge(int[] array, int start, int mid, int end, int[] tmp) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        //左边序列i从[start,mid]，右边序列j从[mid+1,end]
        while (i <= mid && j <= end) {
            //辅助数组tmp存放排序后的值；if(array[i]<=array[j])要有等号，array[i]=array[j]时不是逆序对
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                //count：array[i]>array[j]时，左边有序序列中共有mid-i+1个数字,包括array[i]，这些值均比array[j]大
                count = count + mid - i + 1;
                //取模
                count = count % 1000000007;
            }
        }
        //i<=mid，左边序列还有数字，这些值均比tmp中值大，且已排序，添加至末尾
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        //同理，右边序列还有数字，且已排序，添加至末尾
        while (j <= end) {
            tmp[k++] = array[j++];
        }
        //必须；确保上层调用时下层数组是有序的
        for (i = 0; i < k; i++) {
            array[start + i] = tmp[i];
        }
    }
}
