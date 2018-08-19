package matrix.spiralmatrix2;

import java.util.Scanner;

// 顺序输入，右下左上-螺旋输出
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[][] arr = new int[N][N];
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = num;
                num++;
            }
        }
        int row = N;
        int col = N;
        int start = 0;

        StringBuilder sb = new StringBuilder();
        while (2 * start < row && 2 * start < col) {
            addArr(arr, row, col, start, sb);
            start++;
        }

        System.out.println(sb.toString().trim());
    }

    public static void addArr(int[][] arr, int row, int col, int start, StringBuilder sb) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        // 从左往右
        for (int i = start; i <= endX; i++) {
            sb.append(arr[start][i]).append(" ");
        }
        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                sb.append(arr[i][endX]).append(" ");
            }
        }
        // 从右往左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                sb.append(arr[endY][i]).append(" ");
            }
        }
        // 从下往上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                sb.append(arr[i][start]).append(" ");
            }
        }
    }
}