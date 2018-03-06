package jianzhi_offer.fifty_nine;

import java.util.ArrayList;
import java.util.LinkedList;

//按之字形顺序打印二叉树

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// 按之字形打印需要两个栈。栈后进先出
// 奇数层节点（栈1）从左往右输出（右节点先进栈），偶数层（栈2）从右往左输出（左节点先进栈）。
// 打印奇数层时先保存左节点再保存右节点到栈2
// 打印偶数层时先保存右节点再保存左节点到栈1
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //返回pathlist
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        //每层节点添加到path
        ArrayList<Integer> path = new ArrayList<Integer>();
        //pRoot为null，返回pathlist
        if (pRoot == null) {
            return pathlist;
        }
        //创建两个栈stack1,stack2，奇数层节点保存在stack1，偶数层节点保存在stack2
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();

        //先将pRoot加入到stack1
        stack1.push(pRoot);
        //stack1，stack2不为空时循环执行
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            //stack1不为空
            if (!stack1.isEmpty()) {
                //直到stack1为空
                while (!stack1.isEmpty()) {
                    //弹出栈顶元素
                    TreeNode tmp = stack1.pop();
                    //将元素值添加到path
                    path.add(tmp.val);
                    //先将左节点保存到stack2，再将右节点保存到stack2
                    if (tmp.left != null) {
                        stack2.push(tmp.left);
                    }
                    if (tmp.right != null) {
                        stack2.push(tmp.right);
                    }
                }
                //将path添加到pathlist
                pathlist.add(path);
                //一层元素添加完，重新创建path
                path = new ArrayList<Integer>();
            }
            //否则stack2不为空
            else {
                //直到stack2为空
                while (!stack2.isEmpty()) {
                    //弹出栈顶元素
                    TreeNode tmp = stack2.pop();
                    //将元素值添加到path
                    path.add(tmp.val);
                    //先将右节点保存到stack1，再将左节点保存到stack1
                    if (tmp.right != null) {
                        stack1.push(tmp.right);
                    }
                    if (tmp.left != null) {
                        stack1.push(tmp.left);
                    }
                }
                //将path添加到pathlist
                pathlist.add(path);
                //一层元素添加完，重新创建path
                path = new ArrayList<Integer>();
            }
        }
        //返回pathlist
        return pathlist;
    }
}
