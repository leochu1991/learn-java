package jianzhi_offer.thirteen;

// 调整数组顺序使奇数位于偶数前面
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        int i = 0, j;
        while (i < array.length) {
            //从左到右找到第一个偶数array[i]
            while (i < array.length && !isEven(array[i])) {
                i++;
            }
            //array[i]为偶数，找到i之后的第一个奇数array[j]
            j = i + 1;
            while (j < array.length && isEven(array[j])) {
                j++;
            }
            //交换array[i]和array[j]，并将i和j之间的数字向后移一位
            //必须要有if(j<array.length)，不然会出现j=array.length，越界，即第一个偶数后面都是偶数，已经排好序，就break
            if (j < array.length) {
                int temp = array[j];
                System.arraycopy(array, i, array, i + 1, j - i);
                array[i] = temp;
                i++;
            } else {
                break;
            }
        }

    }

    //判断i是否为偶数
    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
