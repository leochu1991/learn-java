package matrix.snakematrix1;

import java.lang.*;
import java.util.*;

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
        //��ʼ��ʱ��arr[0][0]��arr[N-1][N-1]��ֵ��whileѭ�����Ե�һ�������һ����ֵ
        arr[0][0] = 1;
        arr[N - 1][N - 1] = N * N;
        //��ʼʱ���е��±�
        int row = 0;
        int col = 0;
        int val = 1;
        //����dir��Ĭ��������
        int dir = 0;
        //�ĸ�����down=0��upright=1��right=2��downleft=3��ʹ��final��Ϊ����
        final int down = 0;
        final int upright = 1;
        final int right = 2;
        final int downleft = 3;
        while (val < N * N - 1) {
            switch (dir) {
                case down:
                    //���£���++
                    row++;
                    //��Խ��ʱ���ˣ��ı䷽��
                    if (row >= N) {
                        //�к���
                        row--;
                        //���һ�У����������±�Ϊ����
                        dir = right;
                    } else {
                        //δԽ�磬val++
                        val++;
                        arr[row][col] = val;
                        //ֻ�е�һ�к����һ�в�����
                        //��Ϊ��һ�У������Ϊ����
                        if (col == 0) {
                            dir = upright;
                        }
                        //��Ϊ���һ�У������Ϊ����
                        if (col == N - 1) {
                            dir = downleft;
                        }
                    }
                    break;
                case upright:
                    //��--����++
                    row--;
                    col++;
                    //������<0����>=N
                    if (row < 0) {
                        //��++����--�������Ϊ����
                        row++;
                        col--;
                        dir = right;
                    } else if (col >= N) {
                        //�����Ϊ����
                        row++;
                        col--;
                        dir = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        dir = upright;
                    }
                    break;
                case right:
                    //��++
                    col++;
                    //������>=N
                    if (col >= N) {
                        col--;
                        dir = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        //ֻ�е�һ�к����һ�г�������
                        //��Ϊ��һ�У������Ϊ����
                        if (row == 0) {
                            dir = downleft;
                        }
                        //��Ϊ���һ�У������Ϊ����
                        if (row == N - 1) {
                            dir = upright;
                        }
                    }
                    break;
                case downleft:
                    //��++����--
                    row++;
                    col--;
                    //������>=N����<0
                    if (row >= N) {
                        row--;
                        col++;
                        dir = right;
                    } else if (col < 0) {
                        row--;
                        col++;
                        dir = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        dir = downleft;
                    }
                    break;
            }

        }
        //������ξ���
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
