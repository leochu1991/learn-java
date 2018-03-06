package jianzhi_offer.nineteen;

import java.util.ArrayList;

//顺时针打印矩阵
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //row行，column列
        int row = matrix.length;
        int column = matrix[0].length;
        //matrix为null，返回list
        if (matrix == null || row <= 0 || column <= 0) {
            return list;
        }
        //start表示左上角的坐标，行列坐标相同，每次循环行列都减少两行，两列，循环次数2*start<row&&2*start<column
        //不能取=，偶数行列时，比如4，循环只有0，1两次，没有2
        int start = 0;
        while (2 * start < row && 2 * start < column) {
            printMatrixInCycle(matrix, row, column, start, list);
            start++;
        }

        return list;
    }

    private void printMatrixInCycle(int[][] matrix, int row, int column, int start, ArrayList<Integer> list) {
        //endX表示横向最右边坐标，column-1-start，不是row；start=0，endX=column-1,start=1,endX=column-1-1，类推
        //endY表示纵向最下边坐标，是row-1-start，不是column
        int endX = column - 1 - start;
        int endY = row - 1 - start;
        //从左到右，肯定存在，行start，列从start到endX
        for (int i = start; i <= endX; i++)
            list.add(matrix[start][i]);

        //从上到下，只考虑纵向，start<endY时向下添加，取=时（只有一行）不用向下添加
        if (start < endY) {
            //行从start+1到endY，列endX
            for (int i = start + 1; i <= endY; i++)
                list.add(matrix[i][endX]);
        }

        //从右到左，防止和从左到右的那行重复，需要对行列进行判断，行start<endY，列start<endX
        if (start < endX && start < endY) {
            //行endY，列从endX-1到start，行endY，递减
            for (int i = endX - 1; i >= start; i--)
                list.add(matrix[endY][i]);
        }

        //从下到上，对行列进行判断，start开始行，endY最后一行，这两行第一步和第三步已经添加过
        //所以行start<endY-1时list添加元素
        //列start<endX，防止和从上到下那列重复
        if (start < endX && start < endY - 1) {
            //行endY-1到start+1，列start，递减
            for (int i = endY - 1; i >= start + 1; i--)
                list.add(matrix[i][start]);
        }
    }
}
