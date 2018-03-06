package jianzhi_offer.fifty_six;

// 删除链表中重复的结点

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        //设置虚拟头节点，防止第一个节点就要删除
        ListNode vHead = new ListNode(-1);
        //pHead=null或者pHead.next=null或者pHead不删除时返回vHead.next，即pHead
        vHead.next = pHead;
        //当前节点current
        ListNode current = pHead;
        //当前节点的前一个节点previous，会移动
        ListNode previous = vHead;
        //current!=null&&current.next=null时进入循环
        while (current != null && current.next != null) {
            //当前值和下一个值相等
            if (current.val == current.next.val) {
                int tmp = current.val;
                //直到current的val不等于tmp
                while (current != null && current.val == tmp) {
                    current = current.next;
                }
                previous.next = current;
            }
            //否则current不删除，添加到previous,current右移
            else {
                previous = current;
                current = current.next;
            }
        }
        //返回虚拟节点的下一个节点
        return vHead.next;
    }
}
