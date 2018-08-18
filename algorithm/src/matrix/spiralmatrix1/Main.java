package matrix.spiralmatrix1;

import java.util.Scanner;

// 右下左上-螺旋输入，顺序输出
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }
        int row = N;
        int col = N;
        int start = 0;
        int num = 1;
        while (2 * start < row && 2 * start < col) {
            // 赋值完一圈后将num的值返回给tmp，作为下一次赋值的起始数字
            int tmp = printArr(arr, row, col, start, num);
            start++;
            num = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static int printArr(int[][] arr, int row, int col, int start, int num) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        // 从左往右
        for (int i = start; i <= endX; i++) {
            arr[start][i] = num;
            num++;
        }
        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                arr[i][endX] = num;
                num++;
            }
        }
        // 从右往左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                arr[endY][i] = num;
                num++;
            }
        }
        // 从下往上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                arr[i][start] = num;
                num++;
            }
        }
        return num;
    }
}
