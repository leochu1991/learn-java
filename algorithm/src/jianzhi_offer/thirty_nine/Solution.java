package jianzhi_offer.thirty_nine;

//平衡二叉树 1:null 2:左右子树高度相差不超过1，且左右子树也为平衡二叉树
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Depth {
    int dep;

    Depth(int dep) {
        this.dep = dep;
    }
}

public class Solution {
    // 递归，dfs，会重复遍历节点多次
    public boolean recursiveIsBalanced_Solution(TreeNode root) {
        //root为null，返回true
        if (root == null) {
            return true;
        }

        //求左右子树高度
        int leftdepth = TreeDepth(root.left);
        int rightdepth = TreeDepth(root.right);
        //左右子树高度相差大于1，返回false
        int diff = leftdepth - rightdepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        //递归判断左右子树是否为平衡二叉树
        return recursiveIsBalanced_Solution(root.left) && recursiveIsBalanced_Solution(root.right);
    }

    //递归求解树高
    public int TreeDepth(TreeNode root) {
        //nil，返回0
        if (root == null) {
            return 0;
        }
        //左子树高度leftdepth，右子树高度rightdepth
        int leftdepth = TreeDepth(root.left);
        int rightdepth = TreeDepth(root.right);
        //树的高度为左右子树的高度+1
        return leftdepth > rightdepth ? leftdepth + 1 : rightdepth + 1;
    }

    // 求子树高度和判断平衡均遍历二叉树，可以在遍历节点的时候记录深度，边遍历边判断是否平衡
    // Depth表示树的深度，与c++中的结构对应，为了传递地址，不能用public修饰，只有Solution为public
    public boolean IsBalanced_Solution(TreeNode root) {
        //int depth=0;应传递地址，int* depth;所以定义一个表示深度的类Depth
        Depth depth = new Depth(0);
        return IsBalanced(root, depth);
    }

    public boolean IsBalanced(TreeNode root, Depth pdepth) {
        //root为null，深度为0，返回true
        if (root == null) {
            pdepth.dep = 0;
            return true;
        }
        //int leftdepth=0;
        //int rightdepth=0;
        //表示左子树和右子树的深度，与结构的地址类似，IsBalanced只返回boolean值
        //通过类返回下层深度，达到指针的效果
        Depth leftdepth = new Depth(0);
        Depth rightdepth = new Depth(0);
        //判断递归左右子树是否平衡，并对左右子树的深度赋值
        boolean lefttree = IsBalanced(root.left, leftdepth);
        boolean righttree = IsBalanced(root.right, rightdepth);
        //左右子树平衡，判断左右子树深度相差是否小于1
        if (lefttree && righttree) {
            int diff = leftdepth.dep - rightdepth.dep;
            //|diff|<=1，平衡，赋值当前深度pdepth，返回true
            if (diff <= 1 && diff >= -1) {
                pdepth.dep = leftdepth.dep > rightdepth.dep ? (leftdepth.dep + 1) : (rightdepth.dep + 1);
                return true;
            }
        }
        //左右子树不平衡，直接返回false
        return false;
    }
}
