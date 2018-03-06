package jianzhi_offer.twenty_two;

import java.util.ArrayList;
import java.util.LinkedList;

//从上往下打印二叉树
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// BFS，广度优先遍历，按层遍历，将每层节点加入到队列中，依次弹出
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //root为null，返回[]，即new ArrayList<Integer>()，不是返回null
        if (root == null)
            return new ArrayList<Integer>();
        //遍历的节点值加到list中
        ArrayList<Integer> list = new ArrayList<>();
        //广度优先遍历每个节点加到队列中
        LinkedList<TreeNode> queue = new LinkedList<>();
        //添加root节点
        queue.add(root);
        //队列不为空，执行；isEmpty()是从java.util.AbstractCollection继承来的方法
        while (!queue.isEmpty()) {
            //获取并删除队列头节点
            TreeNode head = queue.poll();
            //如果头节点有左子节点，加入队列
            if (head.left != null)
                queue.add(head.left);
            //如果头节点有右子节点，加入队列
            if (head.right != null)
                queue.add(head.right);
            //将节点值加到ArrayList中
            list.add(head.val);
        }
        return list;
    }
}
