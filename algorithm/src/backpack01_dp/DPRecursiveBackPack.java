package backpack01_dp;

/**
 * 01背包-动态规划递归版
 */
public class DPRecursiveBackPack {

    private static int solve(int index, int length, int[] weight, int[] value, int[][] visited, int limit, int capacity) {
        // 数组越界，返回价值0
        if (index >= length) {
            return 0;
        }
        // visited[index][limit]不为-1，返回最大价值
        if (visited[index][limit] != -1) {
            return visited[index][limit];
        }
        // 当前容量+weight[index]超过最大容量，不取该物品
        if (limit + weight[index] > capacity) {
            return solve(index + 1, length, weight, value, visited, limit, capacity);
        }
        // 取当前物品，背包容量:limit+weight[index],背包价值:resolve(...)+value[index]，否则直接获取下一个物品
        visited[index][limit] = Math.max(solve(index + 1, length, weight, value, visited, limit + weight[index], capacity) + value[index],
                solve(index + 1, length, weight, value, visited, limit, capacity));
        return visited[index][limit];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{4, 3, 2, 5, 1};
        int[] value = new int[]{3, 4, 1, 4, 2};
        int capacity = 10;
        int n = weight.length;
        // visited[i][j]表示index为i，当前背包容量为j的最大价值，初始化为-1
        int[][] visited = new int[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                visited[i][j] = -1;
            }
        }
        int maxValue = solve(0, n, weight, value, visited, 0, capacity);
        System.out.println("visited数组:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("最大价值: " + maxValue);
        // 从index=0开始递归，当前背包容量=0时有最大价值
        System.out.println("最大价值: " + visited[0][0]);
    }
}
