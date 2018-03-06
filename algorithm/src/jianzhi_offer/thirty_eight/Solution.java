package jianzhi_offer.thirty_eight;

import java.util.LinkedList;

//二叉树的深度

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
};

public class Solution {
    // 递归
    public int TreeDepth(TreeNode pRoot) {
        //pRoot为null，返回0
        if (pRoot == null)
            return 0;
        //左右节点均为null，返回1
        if (pRoot.left == null && pRoot.right == null) {
            return 1;
        }
        //left表示左子树的深度，right表示右子树的深度
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        //树的深度等于左右深度中大的加上根节点1
        return left > right ? left + 1 : right + 1;
    }

    //非递归，用队列进行bfs遍历
    public int nonRecursiveTreeDepth(TreeNode pRoot) {
        //pRoot为null，返回0
        if (pRoot == null)
            return 0;
        //左右节点均为null，返回1
        if (pRoot.left == null && pRoot.right == null) {
            return 1;
        }

        int depth = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        //加入pRoot
        queue.add(pRoot);
        //队列不为空
        while (!queue.isEmpty()) {
            //遍历depth层
            depth++;
            //count表示当前层出列次数
            int count = 0;
            //size表示当前depth层的元素个数
            int size = queue.size();
            //出队列size次，count从0到size-1
            while (count < size) {
                //队首元素出列
                TreeNode tmp = queue.remove();
                //tmp有左右节点，加入队列
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                count++;
            }
        }
        //返回depth
        return depth;
    }
}
