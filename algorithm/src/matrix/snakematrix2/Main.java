package matrix.snakematrix2;

import java.util.Scanner;

// 从1开始，直到N*N,方向：右->左下->下->右上
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
        arr[0][0] = 1;
        arr[N - 1][N - 1] = N * N;
        int row = 0;
        int col = 0;
        int val = 1;
        // 起始方向向右
        int direction = 0;
        final int right = 0;
        final int downleft = 1;
        final int down = 2;
        final int upright = 3;
        while (val < N * N - 1) {
            switch (direction) {
                case right:
                    col++;
                    if (col >= N) {
                        col--;
                        direction = down;
                    } else {
                        val++;
                        arr[row][col] = val;
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
                    if (col < 0) {
                        row--;
                        col++;
                        direction = down;
                    } else if (row >= N) {
                        row--;
                        col++;
                        direction = right;
                    } else {
                        val++;
                        arr[row][col] = val;
                        direction = downleft;
                    }
                    break;
                case down:
                    row++;
                    if (row >= N) {
                        row--;
                        direction = right;
                    } else {
                        val++;
                        arr[row][col] = val;
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
                    if (row < 0) {
                        row++;
                        col--;
                        direction = right;
                    } else if (col >= N) {
                        row++;
                        col--;
                        direction = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        direction = upright;
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
