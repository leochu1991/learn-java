package jianzhi_offer.eighteen;

import java.util.Stack;

// 二叉树的镜像
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 递归
    private void recursiveMirror(TreeNode root) {
        //root为null，返回
        if (root == null) {
            return;
        }
        //否则，交换左右子节点
        TreeNode temproot = root.left;
        root.left = root.right;
        root.right = temproot;
        //对左右子节点递归调用Mirror，直到为null，返回
        recursiveMirror(root.left);
        recursiveMirror(root.right);
    }

    // 非递归
    private void nonRecursiveMirror(TreeNode root) {
        //root为null，返回
        if (root == null) {
            return;
        }
        //使用栈模拟，将root节点加入栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            //栈顶节点tn
            TreeNode tn = stack.peek();
            //弹出，所有元素弹出后while结束
            stack.pop();
            //若tn的左右子节点不为null，交换
            if (tn.left != null || tn.right != null) {
                TreeNode temp = tn.left;
                tn.left = tn.right;
                tn.right = temp;
            }
            //左子节点不为null，加入栈
            if (tn.left != null) {
                stack.push(tn.left);
            }
            //右子节点不为null，加入栈
            if (tn.right != null) {
                stack.push(tn.right);
            }
        }
    }
}
