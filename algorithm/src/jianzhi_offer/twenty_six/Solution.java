package jianzhi_offer.twenty_six;

//二叉搜索树与双向链表

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//递归
//将左子树转化为双向链表，返回头节点
//定位至左子树最后一个节点
//若左子树不为null，将root添加到末尾
//将右子树转化为双向链表，返回头节点
//若右子树不为null，将右子树添加到root后
//根据左子树是否为null，返回节点
public class Solution {
    private TreeNode Convert(TreeNode pRootOfTree) {
        //root为null，返回null
        if (pRootOfTree == null) {
            return null;
        }
        //root左右子树为null，返回root
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //转化左子树，返回最左节点left
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        //定位至左子树最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        //左子树双向链表不为null，将root添加到后面
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //转化右子树，返回最左节点right
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        //返回头节点
        return left != null ? left : pRootOfTree;
    }
}
