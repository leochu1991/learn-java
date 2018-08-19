package matrix.snakematrix1;

import java.util.Scanner;

// 从1开始，直到N*N,方向：下->右上->右->左下
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
        // val从2到N*N-2
        arr[0][0] = 1;
        arr[N - 1][N - 1] = N * N;
        int row = 0;
        int col = 0;
        int val = 1;
        // 起始方向向下
        int direction = 0;
        // 四个方向
        final int down = 0;
        final int upright = 1;
        final int right = 2;
        final int downleft = 3;
        while (val < N * N - 1) {
            switch (direction) {
                case down:
                    row++;
                    // 行越界
                    if (row >= N) {
                        // 行--，回退
                        row--;
                        // 向右
                        direction = right;
                    } else {
                        val++;
                        arr[row][col] = val;
                        // 往下后若在第一列，则右上；最后一列左下
                        if (col == 0) {
                            direction = upright;
                        }
                        if (col == N - 1) {
                            direction = downleft;
                        }
                    }
                    break;
                case upright:
                    row--;
                    col++;
                    // row<0或col>N
                    if (row < 0) {
                        // 行++，列--，回退
                        row++;
                        col--;
                        // 向右
                        direction = right;
                    } else if (col >= N) {
                        row++;
                        col--;
                        // 向下
                        direction = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        // 继续右上
                        direction = upright;
                    }
                    break;
                case right:
                    col++;
                    if (col >= N) {
                        col--;
                        direction = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        // row=0，左下；row=N-1,右上
                        if (row == 0) {
                            direction = downleft;
                        }
                        if (row == N - 1) {
                            direction = upright;
                        }
                    }
                    break;
                case downleft:
                    row++;
                    col--;
                    if (row >= N) {
                        row--;
                        col++;
                        // N-1行越界，向右
                        direction = right;
                    } else if (col < 0) {
                        row--;
                        col++;
                        // -1列越界，向下
                        direction = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        // 继续左下
                        direction = downleft;
                    }
                    break;
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
