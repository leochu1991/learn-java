package jianzhi_offer.fifty_eight;

import java.util.LinkedList;

// 对称的二叉树
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 比较二叉树的先序遍历和对称先序遍历来判断二叉树是否对称，如果两个序列一样则对称
    // 递归
    boolean isSymmetrical1(TreeNode pRoot) {
        //重载isSymmetrical()
        return isSymmetrical(pRoot, pRoot);
    }

    //pleft,pright表示左右子树
    public boolean isSymmetrical(TreeNode pleft, TreeNode pright) {
        //左右子树为null，返回true
        if (pleft == null && pright == null)
            return true;
        //左右子树只有一个为null，返回false
        if (pleft == null || pright == null)
            return false;
        //左右子树均不为null，但val不等，返回false
        if (pleft.val != pright.val)
            return false;
        //递归调用，判断pleft的左子树和pright的右子树，pleft的右子树和pright的左子树是否对称
        return isSymmetrical(pleft.left, pright.right) && isSymmetrical(pleft.right, pright.left);
    }

    //非递归，利用队列
    boolean isSymmetrical2(TreeNode pRoot) {
        //若pRoot为null，返回true
        if (pRoot == null)
            return true;
        //两个队列分别存放先序遍历结果和对称先序遍历结果
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(pRoot.left);
        queue2.add(pRoot.right);
        //queue1和queue2队列不为null
        while (queue1.size() > 0 && queue2.size() > 0) {
            //获取并移除队首元素
            TreeNode left = queue1.remove();
            TreeNode right = queue2.remove();
            //左右子树均为null，继续判断，continue
            if (left == null && right == null)
                continue;
            //左右子树任一为null，返回false，不对称
            if (left == null || right == null)
                return false;
            //左右子树val不相等，返回false
            if (left.val != right.val)
                return false;
            //左右子树均不为null，加入队列
            //将left的左子树和右子树加入队列（先序遍历）
            queue1.add(left.left);
            queue1.add(left.right);
            //将right的右子树和左子树加入队列，和queue1对称（对称先序遍历）
            queue2.add(right.right);
            queue2.add(right.left);
        }
        //queue1和queue2都相等，返回true
        return true;
    }
}
