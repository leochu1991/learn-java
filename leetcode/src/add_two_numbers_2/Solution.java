package add_two_numbers_2;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// 2. Add Two Numbers
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode ret = l3;
        int carry = 0;
        int value = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            l3.next = new ListNode(0);
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else { // carry = 1 进位
                sum = carry;
            }
            value = sum % 10;
            carry = sum / 10;
            l3.next.val = value;
            l3 = l3.next;
        }
        return ret.next;
    }
}