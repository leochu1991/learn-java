package jianzhi_offer.thirty_six;

// 两个链表的第一个公共结点

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

// 如果两个链表有公共节点，那么这两个链表从某一节点开始，它们的next都指向同一个节点
// 之后所有的节点都是重合的，不再出现分叉，拓扑形状看起来是Y型
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //pHead1,pHead2任一为null，返回null
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //求长度
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        //pHead1长，则pHead1先走len1-len2，使两个链表末尾对齐
        if (len1 >= len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }
        //遍历节点，val相等break，否则指向next，直至尾部null
        while (pHead1 != null) {
            if (pHead1.val == pHead2.val) {
                break;
            } else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        //返回pHead1，若未找到，则返回null
        return pHead1;
    }

    //遍历求链表长度
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
