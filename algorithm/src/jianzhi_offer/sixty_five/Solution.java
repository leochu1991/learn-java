package jianzhi_offer.sixty_five;

// 矩阵中的路径
// 回溯，递归，栈
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //参数校验
        if (matrix == null || rows < 1 || cols < 1 || str == null || str.length < 1) {
            return false;
        }
        //visited表示矩阵是否访问过，初始为false
        boolean[] visited = new boolean[rows * cols];
        for (boolean v : visited) {
            v = false;
        }
        //返回hasPath，默认为false
        boolean hasPath = false;
        //从str的0位置开始查找
        int pathLength = 0;
        //从任意位置开始寻找
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //若找到该路径，则hasPath置为true
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    hasPath = true;
                    break;
                }
            }
        }
        //返回hasPath
        return hasPath;
    }

    //回溯法
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        //递归出口，若遍历完字符串，则返回true，不能用str[pathLength]=='\0'
        if (pathLength == str.length) {
            return true;
        }
        //初始hasPath为false
        boolean hasPath = false;
        //判断边界0<=row<rows&&0<=col<cols，字符是否相等，矩阵是否访问过
        if (0 <= row && row < rows && 0 <= col && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            //设置visited为已访问
            visited[row * cols + col] = true;
            //判断下一个字符
            pathLength++;
            //递归matrix[row][col]的上下左右四个位置是否为下一个字符的位置
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);
            //若未找到下一个字符，则回退
            if (!hasPath) {
                //回退一个字符，从pathLenth+1变成pathLength-1，重新定位pathLength个字符，第一个字符必须相等，
                //先pathLength++后pathLength--不会越界
                pathLength--;
                //visited置为false
                visited[row * cols + col] = false;
            }
        }
        //返回hasPath
        return hasPath;
    }
}
