package longest_increasing_subsequence;

import java.util.Arrays;

/**
 * 一维数组的最长递增子序列
 */
public class LISDemo1 {
    // 返回记录array最长递增子序列长度的dp数组
    public static int[] getLISArray(int[] array, int length) {
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            // dp[i] = MAX{1, dp[j] + 1}, 对任意0<= j <= i-1成立
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        // 返回dp数组
        return dp;
    }

    // 返回array的最长递增子序列的长度
    public static int getLISLength(int[] dp, int length) {
        int lis = 1;
        for (int i = 0; i < length; i++) {
            if (dp[i] > lis) {
                lis = dp[i];
            }
        }
        return lis;
    }

    // 输出最长递增子序列
    public static void printLISArray(int[] array, int[] dp, int lis, int index) {
        boolean isLIS = false;
        // 递归出口
        if (lis == 0 || index < 0) {
            return;
        }
        // dp[index]是最长递增子序列的长度lis
        if (dp[index] == lis) {
            isLIS = true;
            lis--;
        }
        // --index，递归
        printLISArray(array, dp, lis, --index);
        // java栈，后进先出，输出lis
        if (isLIS) {
            System.out.print(array[index + 1] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 2, -3, 4, -5, 6, -7};
        int[] dp = getLISArray(array, array.length);
        System.out.printf("dp is: %s%n", Arrays.toString(dp));
        int lis = getLISLength(dp, dp.length);
        System.out.println("LIS is: " + lis);
        System.out.printf("原数组：%s%n", Arrays.toString(array));
        System.out.print("最长递增子序列：");
        printLISArray(array, dp, lis, array.length - 1);
    }
}
