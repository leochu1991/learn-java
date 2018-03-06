package jianzhi_offer.sixty_two;

//二叉搜索树的第k个结点

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// 中序遍历二叉搜索树，左-根-右
// 二叉搜索树左节点小于根节点小于右节点，和中序遍历顺序一致
public class Solution {
    //表示第几个数，初始化为1
    int count = 1;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        return KthNodeCore(pRoot, k);
    }

    TreeNode KthNodeCore(TreeNode pRoot, int k) {
        //返回res
        TreeNode res = null;
        //先从左子树开始查找
        if (pRoot.left != null) {
            res = KthNodeCore(pRoot.left, k);
        }
        //res为null，说明左子树未找到
        if (res == null) {
            //寻找根节点
            if (count == k) {
                res = pRoot;
            }
            //判断根节点是否是第k小的节点，计数器count++
            count++;
        }
        //res为null，说明根节点也没有找到，继续遍历右子树，注意判断pRoot.right!=null
        if (res == null && pRoot.right != null) {
            res = KthNodeCore(pRoot.right, k);
        }
        //返回res
        return res;
    }
}
