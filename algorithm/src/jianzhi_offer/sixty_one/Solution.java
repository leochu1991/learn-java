package jianzhi_offer.sixty_one;

//序列化二叉树

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// 递归，先序遍历，若左右节点为null，返回"#"
public class Solution {
    //反序列化时递归的下标，从-1开始
    public int index = -1;

    String Serialize(TreeNode root) {
        //每次返回一个新的字符串tree
        StringBuilder tree = new StringBuilder();
        //若root为null，返回"#,"
        if (root == null) {
            tree.append("#,");
            return tree.toString();
        }
        //递归先序遍历，根-左-右
        tree.append(root.val + ",");
        tree.append(Serialize(root.left));
        tree.append(Serialize(root.right));

        return tree.toString();
    }

    TreeNode Deserialize(String str) {
        //下标++
        index++;
        if (str == null || str.length() == 0) {
            return null;
        }
        //将str转化为String[]
        String[] strs = str.split(",");
        int len = str.length();
        //strs中字符为#时，返回null
        TreeNode node = null;
        //二叉树为先序顺序
        //下标未越界，且不为#
        if (index < len && !strs[index].equals("#")) {
            //先序，根-左-右
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        //返回节点
        return node;
    }
}
