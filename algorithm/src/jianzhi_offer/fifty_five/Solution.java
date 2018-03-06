package jianzhi_offer.fifty_five;

// 链表中环的入口结点

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //pHead为null或者只有一个节点pHead，返回null（防止下面只有一个节点时返回current）
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //current表示当前节点，next表示当前节点的下一个节点
        ListNode current = pHead;
        ListNode next = pHead.next;
        //每次将当前节点的下一个节点置为null，断开链表，直到链表最后一个节点，即为环的入口节点
        //下一个节点为null时跳出循环
        while (next != null) {
            //断开链表
            current.next = null;
            //current和next向后移动一个节点
            current = next;
            next = next.next;
        }
        //返回链表中的最后一个节点current
        return current;
    }
}
