package jianzhi_offer.twenty_three;

// 二叉搜索树的后序遍历序列
public class Solution {
    // BST：任意两个数字互不相同，最后一个数字为根元素，其它数字分为两个序列，前面一个序列为左子树，值小于根元素
    // 后面一个序列为右子树，值大于根元素，递归调用看左右子树是否满足同样规律
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int len = sequence.length;
        return verifyBST(sequence, 0, len - 1);
    }

    //后序遍历，左右根。left最左边元素，right最右边元素，即为根元素
    private boolean verifyBST(int[] sequence, int left, int right) {
        //left>=right,不是left==right（只有根元素，返回true），若没有右子树，数组为[1 2]，调用verifyBST(sequence,root+1,right-1)
        //root=0,right=1,verifyBST(sequence,1,0)，出现越界，应直接返回true
        if (left >= right) {
            return true;
        }
        //查找左右子树，任意两个数字互不相同
        int root = right - 1;
        //从右往左遍历，找到第一个比sequence[right]小的root，即为左子树的root
        //左子树在[left,root]，右子树在[root+1,right-1]，且右子树均大于sequence[right]
        while (left <= root && sequence[root] > sequence[right]) {
            root--;
        }
        //判断左子树是否全部小于sequence[right]
        for (int i = left; i <= root; i++) {
            if (sequence[i] > sequence[right])
                return false;
        }
        //递归调用看左右子树是否满足同样规律
        return verifyBST(sequence, left, root) && verifyBST(sequence, root + 1, right - 1);
    }

    // 非递归，二叉搜索树满足左子树元素<根元素<右子树元素，所以后序遍历(左-右-根)结果是左子树元素均小于右子树元素和根元素
    public boolean nonRecursiveVerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int len = sequence.length - 1;
        int i = 0;
        while (len >= 0) {
            //找到左子树，最后i变为右子树的第一个值，sequence[i]>sequence[len]，跳出循环
            while (sequence[i] < sequence[len]) {
                i++;
            }
            //找到右子树，最后i变为len
            while (sequence[i] > sequence[len]) {
                i++;
            }
            //若i比len小，说明数组不满足二叉搜索树后序遍历，返回false
            if (i < len) {
                return false;
            }
            //len--
            len--;
            //i置为0
            i = 0;
        }
        return true;
    }
}
