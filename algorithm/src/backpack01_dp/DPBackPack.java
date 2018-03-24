package backpack01_dp;

/**
 * 01背包-动态规划递推版
 */
public class DPBackPack {

    private static int solve(int[] weight, int[] value, int length, int[][] dp, int capacity) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                // 对于每个物品weight[i],若超过当前背包容量j,则不能取该物品
                if (weight[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // 否则 1.不取该物品(dp[i][j]) 2.取该物品(dp[i][j-weight[i]]+value[i])
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[length][capacity];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{4, 3, 2, 5, 1};
        int[] value = new int[]{3, 4, 1, 4, 2};
        int capacity = 10;
        int n = weight.length;
        // dp[i][j]表示前i个物品，当前背包容量为j的最大价值，初始化为0
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = 0;
            }
        }
        int maxValue = solve(weight, value, n, dp, capacity);
        System.out.println("dp数组:");
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("最大价值: " + maxValue);
    }
}
