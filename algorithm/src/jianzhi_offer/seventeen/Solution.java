package jianzhi_offer.seventeen;

//树的子结构

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//要查找树A中是否存在和树B结构一样的子树，我们可以分成两步：第一步在树A中找到和B的根结点的值一样的结点R
//第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构
public class Solution {
    private boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //判断是否为null，任意为null均返回false
        if (root1 == null || root2 == null)
            return false;

        boolean result = false;
        //root1，root2均不为null
        if (root1 != null && root2 != null) {
            //root1中含有和root2一样的节点
            if (root1.val == root2.val)
                result = DoesTree1HasTree2(root1, root2);
            //result为false时，判断root1的左节点是否包含root2，递归
            if (!result)
                result = HasSubtree(root1.left, root2);
            //result为false时，判断root1的右节点是否包含root2，递归
            if (!result)
                result = HasSubtree(root1.right, root2);
        }
        //返回result
        return result;

    }

    //判断root1是否包含root2的结构
    private boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        //root2为null，返回true（在递归时比较，因为根节点为true，所以root2为null时，root1也包含root2，返回true）
        if (root2 == null)
            return true;
        //root1为null，返回false
        if (root1 == null)
            return false;
        //递归调用时比较是否相等
        if (root1.val != root2.val)
            return false;
        //递归比较root1和root2的左右节点是否相等，并返回
        return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }
}
