package backtrack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组元素和为给定值，回溯；数组元素和最大，动态规划
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        // 输入目标target，n个元素
        int target = cin.nextInt();
        int n = cin.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int sum = 0;
        Arrays.sort(arr);
        boolean[] book = new boolean[n];
        Arrays.fill(book, false);
        int index = 0;
        // 回溯
        backtrack(arr, n, index, sum, target, book);
    }

    public static void backtrack(int[] arr, int n, int index, int sum, int target, boolean[] book) {
        // sum>target或数组越界index>n，不取=，返回
        if (sum > target || index > n) {
            return;
        }
        // sum=target，输出
        if (sum == target) {
            for (int i = 0; i < n; i++) {
                if (book[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        // sum<target
        for (int i = index; i < n; i++) {
            if (!book[i]) {
                book[i] = true;
                sum += arr[i];
                // 注意i+1，不是index+1
                backtrack(arr, n, i + 1, sum, target, book);
                // 回溯
                sum -= arr[i];
                book[i] = false;
                // 去除相同的arr元素
                while (i < n - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
    }
}
