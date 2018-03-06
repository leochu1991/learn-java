package jianzhi_offer.fourteen;

//链表中倒数第k个结点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode findKthToTail(ListNode head, int k) {
        //head为空或者k<=0，返回null
        if (head == null || k <= 0) {
            return null;
        }
        //前后两个指针，相隔k
        ListNode first = head;
        ListNode second = head;
        //first先走k步
        while (k > 0) {
            //判断first是否已经到达尾端，即判断k是否大于链表长度，到达则返回null
            if (first != null) {
                first = first.next;
                k--;
            } else {
                return null;
            }
        }
        //first和second同步走，直到first到达链表尾，返回second
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
