package jianzhi_offer.four;

//重建二叉树

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 递归方式重建二叉树
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 方法名用reConstructBinaryTree1与reConstructBinaryTree区别，可以一样，方法重载
        TreeNode root = reConstructBinaryTree1(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree1(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 表示没有子节点，nil
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // root在pre的startPre位置
        TreeNode root = new TreeNode(pre[startPre]);
        // 在in中从startIn到endIn查找root的位置
        for (int i = startIn; i <= endIn; i++) {
            // root在in的i位置
            if (in[i] == pre[startPre]) {
                // 重建左子树，左子树在pre的[startPre+1,startPre+1+(i-1-startIn+1)-1]，即[startPre+1,startPre+i-startIn]，在in的[startIn,i-1]
                root.left = reConstructBinaryTree1(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                // 重建右子树，右子树在pre的[startPre+i-startIn+1,endPre]，在in的[i+1,endIn]
                root.right = reConstructBinaryTree1(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}