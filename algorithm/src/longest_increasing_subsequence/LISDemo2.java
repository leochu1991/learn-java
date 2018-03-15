package longest_increasing_subsequence;

import java.util.Arrays;

/**
 * 最长递增子序列 quicksort + lcs(最长公共子序列)
 * 最长递增子序列与排序后的数组有相同的最长公共子序列
 */
public class LISDemo2 {
    // 快速排序
    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, index, i);
                index++;
            }
        }
        swap(array, left, index - 1);
        quicksort(array, left, index - 2);
        quicksort(array, index, right);
    }

    // 交换array[i],array[j]
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 最长公共子序列lcs-动态规划
    public static int[][] getLCSArray(int[] array, int[] sortedarray, int length) {
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                // 对于每个array[i-1]，遍历排序后的数组sortedarray[j-1]，若相等，则该元素可能为lcs中的元素，dp数组值+1
                if (array[i - 1] == sortedarray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (dp[i - 1][j] > dp[i][j - 1]) { // 否则 dp[i][j] = MAX {dp[i-1][j],dp[i][j-1]}
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    // 根据dp数组打印输出最长公共子序列，即最长递增子序列
    public static void printLCSArray(int[] array, int[][] dp, int length) {
        // TODO: 2018/3/14 打印输出lcs 
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 2, -3, 4, -5, 6, -7};
        System.out.println("原数组：" + Arrays.toString(array));
        int[] arraycopy = new int[array.length];
        System.arraycopy(array, 0, arraycopy, 0, array.length);
        quicksort(arraycopy, 0, array.length - 1);
        System.out.println("快速排序后数组：" + Arrays.toString(arraycopy));
        int[][] dp = getLCSArray(array, arraycopy, array.length);
        System.out.println("dp数组：");
        for (int i = 0; i < array.length + 1; i++) {
            for (int j = 0; j < array.length + 1; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("最长递增子序列的长度：" + dp[array.length][array.length]);
    }
}
