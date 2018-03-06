package jianzhi_offer.fifty_seven;

// 二叉树的下一个结点

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

// 中序遍历，左-根-右
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //pNode为null，返回null
        if (pNode == null) {
            return null;
        }
        //防止当前节点pNode为二叉树的最后一个节点，其下一个节点为null
        TreeLinkNode pNext = null;

        //当前节点有右节点，下一个节点为右子树的最左节点
        if (pNode.right != null) {
            //pRight表示当前节点的右节点
            TreeLinkNode pRight = pNode.right;
            //pRight有左子树，循环
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            //返回最左节点
            pNext = pRight;
        }
        //当前节点没有右节点，但有父节点
        //则返回节点p是其父节点p1的左孩子，即（p.next=p1&&p=p1.left）
        else if (pNode.next != null) {
            //pCurrent表示当前节点
            TreeLinkNode pCurrent = pNode;
            //pParent表示pCurrent的父节点
            TreeLinkNode pParent = pCurrent.next;
            //循环，直到当前节点pCurrent是其父节点pParent的左孩子
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.next;
            }
            //返回父节点pParent
            pNext = pParent;
        }
        //否则既没有右节点又没有父节点，即pNode为根节点，且只有左子树，下一个节点为null
        //返回pNext
        return pNext;
    }
}
