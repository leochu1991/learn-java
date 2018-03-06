package jianzhi_offer.three;

import java.util.ArrayList;

// 从尾到头打印链表
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 后进先出，栈结构，用递归
        ArrayList<Integer> ls = new ArrayList<Integer>();
        // 不用while用if，用while时ls.add()会一直添加节点，进入死循环
        if (listNode != null) {
            if (listNode.next != null) {
                ls = printListFromTailToHead(listNode.next);
            }
            ls.add(listNode.val);
        }
        return ls;
    }
}