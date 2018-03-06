package jianzhi_offer.sixty;

import java.util.ArrayList;
import java.util.LinkedList;

// 把二叉树打印成多行

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //每层节点加入到path
        ArrayList<Integer> path = new ArrayList<>();
        //返回pathlist
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        //pRoot为null，返回pathlist
        if (pRoot == null) {
            return pathlist;
        }
        //创建队列queue，存放每层节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        //添加队首
        queue.add(pRoot);
        //当前层节点数count，初始时只有根节点，为1
        int count = 1;
        //下层节点数nextLevel，初始时为0
        int nextLevel = 0;
        //队列不为空
        while (!queue.isEmpty()) {
            //弹出队首元素tmp
            TreeNode tmp = queue.remove();
            //当前节点有左孩子，加入到队列；下层节点数加1
            if (tmp.left != null) {
                queue.add(tmp.left);
                nextLevel++;
            }
            //当前节点有右孩子，加入到队列；下层节点数加1
            if (tmp.right != null) {
                queue.add(tmp.right);
                nextLevel++;
            }
            //当前层节点数减1
            count--;
            //当前节点值val加入到path
            path.add(tmp.val);
            //当前层遍历完，即count=0，则将path加入到pathlist，并遍历下层
            if (count == 0) {
                //count变为下层节点数
                count = nextLevel;
                //下层节点数置0，否则count--后不为0，但队列已经为空，二叉树的第三层就不能添加到pathlist
                nextLevel = 0;
                //添加当前层到pathlist
                pathlist.add(path);
                //创建新的path
                path = new ArrayList<Integer>();
            }
        }
        //返回pathlist
        return pathlist;
    }
}
