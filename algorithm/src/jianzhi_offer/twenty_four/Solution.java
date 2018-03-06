package jianzhi_offer.twenty_four;

import java.util.ArrayList;

// 二叉树中和为某一值的路径

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// 当用前序遍历的方式访问到某一节点时，我们把这个节点添加到路径上，并累加该节点的值，如果该节点为叶子
// 节点并且路径中节点值的和刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来。如果当前节点不
// 是叶节点，则继续访问它的子节点。当前节点访问结束后，递归函数将自动回到它的父节点。因此我们在函数退
// 出之前要在路径上删除当前节点，并减去当前节点的值，以确保返回父节点时路径刚好是从根节点到父节点的路
// 径。不难看出保存路径的数据结构实际上是一个栈。
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //每一条路径path
        ArrayList<Integer> path = new ArrayList<>();
        //返回的路径之和
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        //root为空，返回pathlist
        if (root == null) {
            return pathlist;
        }
        //递归调用，深度遍历
        int cursum = 0;
        FindPath(root, target, cursum, path, pathlist);
        return pathlist;
    }

    //路径从根节点出发，先序遍历
    private void FindPath(TreeNode root, int target, int cursum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathlist) {
        //添加当前节点的值到cursum
        cursum = cursum + root.val;
        path.add(root.val);
        boolean isLeaf = (root.left == null) && (root.right == null);
        //当前节点是叶子节点且和等于目标
        if (isLeaf && target == cursum) {
            //添加到pathlist，注意要new！！！否则还是一条路径
            pathlist.add(new ArrayList<Integer>(path));
        }
        //根-左-右，寻找路径
        if (root.left != null) {
            FindPath(root.left, target, cursum, path, pathlist);
        }
        if (root.right != null) {
            FindPath(root.right, target, cursum, path, pathlist);
        }
        //是叶子节点但和不等于目标，移除路径上当前节点的值，返回父节点
        //移除path上最后一个节点
        path.remove(path.size() - 1);
    }
}
