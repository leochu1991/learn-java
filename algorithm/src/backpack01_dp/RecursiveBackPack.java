package backpack01_dp;

/**
 * 01背包-递归版
 */
public class RecursiveBackPack {
    /**
     * @param index    数组下标
     * @param length   数组长度
     * @param weight   每个物品的重量数组
     * @param value    每个物品的价值数组
     * @param limit    当前背包容量
     * @param capacity 背包的最大容量
     * @return 背包所装物品的最大价值
     */
    private static int solve(int index, int length, int[] weight, int[] value, int limit, int capacity) {
        // 数组越界，没有物品，返回价值0
        if (index >= length) {
            return 0;
        }
        // 选择当前物品，容量超过capacity，则不选择该物品(limit不变)，继续递归(index+1)
        if (limit + weight[index] > capacity) {
            return solve(index + 1, length, weight, value, limit, capacity);
        }
        // 否则选该物品(背包容量:limit+weight[index],背包价值:solve(...)+value[index])或不选该物品,继续递归(index+1)
        return Math.max(solve(index + 1, length, weight, value, limit + weight[index], capacity) + value[index],
                solve(index + 1, length, weight, value, limit, capacity));
    }

    public static void main(String[] args) {
        int[] weight = new int[]{4, 3, 2, 5, 1};
        int[] value = new int[]{3, 4, 1, 4, 2};
        int capacity = 10;
        int n = weight.length;
        int maxValue = solve(0, n, weight, value, 0, capacity);
        System.out.println("最大价值: " + maxValue);
    }
}
