package jianzhi_offer.forty_two;

import java.util.ArrayList;

// 和为S的两个数字
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int begin = 0;
        int end = array.length - 1;

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();

        while (begin < end) {
            if (array[begin] + array[end] > sum) {
                end--;
            }

            if (array[begin] + array[end] < sum) {
                begin++;
            }

            if (array[begin] + array[end] == sum) {
                arr.add(array[begin]);
                arr.add(array[end]);
                arr.add(array[begin] * array[end]);

                begin++;
                end--;
            }
        }

        if (arr.size() == 0) {
            return arr1;
        } else {
            int index = 2, num = arr.get(2);

            for (int i = 2; i <= arr.size(); i = i + 3) {
                if (arr.get(i) < num) {
                    index = i;
                    num = arr.get(i);
                }
            }
            arr1.add(arr.get(index - 2));
            arr1.add(arr.get(index - 1));
            return arr1;
        }
    }
}
