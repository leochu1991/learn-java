package jianzhi_offer.fifteen;

//反转链表
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 递归方式反转链表
    public ListNode recursiveReverseList(ListNode head) {
        //head为null或者head只有一个节点，直接返回head
        if (head == null || head.next == null) {
            return head;
        }
        //nextNode表示下一个节点
        ListNode nextNode = head.next;
        //将head节点与next节点断开，防止两两节点形成一个圈
        head.next = null;
        //递归调用，依次将每个节点与链表断开
        ListNode reverseRest = recursiveReverseList(nextNode);
        //反转链表，重建链表
        nextNode.next = head;
        //reverseRest递归后表示最后一个节点，返回
        return reverseRest;
    }

    // 非递归方式反转链表
    public ListNode nonRecursiveReverseList(ListNode head) {
        //head为null或者head只有一个节点，直接返回head
        if (head == null || head.next == null) {
            return head;
        }
        //两个节点，nextNode表示head的下一个节点，preNode表示head之前的节点
        ListNode nextNode = null;
        ListNode preNode = null;
        //当前节点不为null
        while (head != null) {
            //保存next节点
            nextNode = head.next;
            //反转链表，更新next的值为preNode
            head.next = preNode;
            //将preNode和head向后移一位，直到head为null，最后一个节点为preNode，返回
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}
