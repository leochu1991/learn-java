package jianzhi_offer.sixteen;

//合并两个排序的链表

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 递归
    private ListNode recursiveMerge(ListNode list1, ListNode list2) {
        // 若list1为null，返回list2；若list2为null，返回list1
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //head为下一个返回的节点，list1.val<list2.val，下一个返回list1，head.next为下次比较结果，递归调用Merge
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = recursiveMerge(list1.next, list2);
        } else {
            head = list2;
            head.next = recursiveMerge(list1, list2.next);
        }

        return head;
    }

    // 非递归
    public ListNode nonRecursiveMerge(ListNode list1, ListNode list2) {
        // 若list1为null，返回list2；若list2为null，返回list1
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //确定头节点
        ListNode head = null;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        //phead表示head的指针向后遍历，返回head
        ListNode phead = head;
        //Merge
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                phead.next = list1;
                list1 = list1.next;
                //phead指向list1位置
                phead = phead.next;
            } else {
                phead.next = list2;
                list2 = list2.next;
                //phead指向list2位置
                phead = phead.next;
            }
        }
        //一个链表变成null，将剩下一个链表加到phead后面
        if (list1 == null) {
            phead.next = list2;
        } else {
            phead.next = list1;
        }
        return head;
    }
}
