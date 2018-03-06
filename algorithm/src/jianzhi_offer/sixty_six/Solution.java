package jianzhi_offer.sixty_six;

// 机器人的运动范围
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        //visited标记是否能进入
        boolean[] visited = new boolean[rows * cols];
        for (boolean v : visited) {
            v = false;
        }
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    //回溯法
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        //check为true
        if (check(threshold, rows, cols, row, col, visited)) {
            //visited[row*cols+col]表示[row,col]已进入
            visited[row * cols + col] = true;
            //回溯，上下左右四个位置是否可以进入
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    //校验是否可以进入
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        //row和col满足边界条件，且数位和小于threadhold，且可以进入，返回true
        if (0 <= row && row < rows && 0 <= col && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col]) {
            return true;
        }
        //否则返回false
        return false;
    }

    //获得数位和
    public int getDigitSum(int num) {
        int sum = 0;
        while (num % 10 != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
