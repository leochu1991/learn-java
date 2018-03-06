package matrix.snakematrix2;

import java.lang.*;
import java.util.*;

//���ξ���
//������->����->��->����

public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //��ʼ��Ϊ0
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
        //�ĸ�����right=0��downleft=1��down=2��upright=3��ʹ��final��Ϊ����
        final int right = 0;
        final int downleft = 1;
        final int down = 2;
        final int upright = 3;
        while (val < N * N - 1) {
            switch (dir) {
                case right:
                    //���ң���++
                    col++;
                    //��Խ��ʱ���ˣ��ı䷽��
                    if (col >= N) {
                        //�к���
                        col--;
                        //���һ�У����������ұ�Ϊ����
                        dir = down;
                    } else {
                        //δԽ�磬val++
                        val++;
                        arr[row][col] = val;
                        //ֻ�е�һ�к����һ�в�����
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
                    //������<0����>=N
                    if (col < 0) {
                        //��--����++�������Ϊ����
                        row--;
                        col++;
                        dir = down;
                    } else if (row >= N) {
                        //�����Ϊ����
                        row--;
                        col++;
                        dir = right;
                    } else {
                        val++;
                        arr[row][col] = val;
                        //�����򲻱�
                        dir = downleft;
                    }
                    break;
                case down:
                    //��++
                    row++;
                    //������>=N
                    if (row >= N) {
                        //��--�������Ϊ��
                        row--;
                        dir = right;
                    } else {
                        val++;
                        arr[row][col] = val;
                        //ֻ�е�һ�к����һ�г�������
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
                        row++;
                        col--;
                        //�����Ϊ��
                        dir = right;
                    } else if (col >= N) {
                        row++;
                        col--;
                        //�����Ϊ��
                        dir = down;
                    } else {
                        val++;
                        arr[row][col] = val;
                        //�����򲻱�
                        dir = upright;
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
