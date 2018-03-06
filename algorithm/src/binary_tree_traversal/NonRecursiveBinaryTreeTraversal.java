package binary_tree_traversal;

import java.util.LinkedList;

/**
 * 二叉树遍历，前序，中序，后序
 */
class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class NonRecursiveBinaryTreeTraversal {
    // 前序非递归遍历二叉树
    public static void preOrderTraversal(TreeNode root) {
        //树为null，返回
        if (root == null) {
            return;
        }
        //树不为null，输出根节点，并加入栈中，直到栈为空或者p为null
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || p != null) {
            //遍历左子树，输出根节点，并加入栈中，直到p为左节点，或者p为根节点，但没有左节点
            while (p != null) {
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            //p=null，出栈
            if (!stack.isEmpty()) {
                //弹出左节点或根节点
                p = stack.pop();
                //更新p为右节点，p可能为null
                p = p.right;
            }
        }
    }

    // 中序非递归遍历二叉树
    public static void inOrderTraversal(TreeNode root) {
        //树为null，返回
        if (root == null) {
            return;
        }
        //树不为null，加入栈中，直到栈为空或者p为null
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || p != null) {
            //遍历左子树，直到p为左节点，或者p为根节点，但没有左节点
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //p=null，出栈
            if (!stack.isEmpty()) {
                //弹出左节点或根节点
                p = stack.pop();
                //输出p的值
                System.out.print(p.val + " ");
                //更新p为右节点，p可能为null
                p = p.right;
            }
        }
    }

    // 后序非递归遍历二叉树
    public static void postOrderTraversal(TreeNode root) {
        //树为null，返回
        if (root == null) {
            return;
        }
        //树不为null，加入栈中，直到栈为空
        //pCur表示当前节点，pLastVisted表示前一个访问的节点
        TreeNode pCur = root;
        TreeNode pLastVisited = null;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        //遍历左子树，将所有左节点加入stack
        while (pCur != null) {
            stack.push(pCur);
            pCur = pCur.left;
        }
        while (!stack.isEmpty()) {
            //pCur=null
            pCur = stack.pop();
            //pCur没有右子树或者右子树已经访问过，则访问根节点
            if (pCur.right == null || pLastVisited == pCur.right) {
                System.out.print(pCur.val + " ");
                //更新pLastVisited
                pLastVisited = pCur;
            } else {
                //否则pLastVisited=pCur.left，根节点入栈，访问右子树
                stack.push(pCur);
                pCur = pCur.right;
                //查找到右子树的最左子树节点
                while (pCur != null) {
                    stack.push(pCur);
                    pCur = pCur.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建二叉树，返回root
    }
}
