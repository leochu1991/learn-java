package reverse_list;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转带环单链表
 */
public class ReverseListWithCycleUseSet {
    // 反转带环单链表
    public Node reverseListWithCycle(Node head) {
        Node prev = null;
        Node cur = head;
        Set<Integer> set = new HashSet<>();

        while (cur != null) {
            // cur节点第二次遍历，为环的开始节点
            if (set.contains(cur.hashCode())) {
                // 新建一个节点，防止破坏原来交点的指针，环会断开
                Node newHead = new Node(cur.value);
                newHead.next = prev;
                return newHead;
            }
            // 已遍历节点，加入set
            set.add(cur.hashCode());
            // 更新指针
            Node tmp = cur.next;
            cur.next = prev;
            // 更新节点
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    // 打印链表
    public void printList(Node head) {
        Node pHead = head;
        Set<Integer> set = new HashSet<>();
        while (pHead != null) {
            System.out.print(pHead.value + " ");
            if (set.contains(pHead.hashCode())) {
                break;
            }
            set.add(pHead.hashCode());
            pHead = pHead.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = d;

        System.out.print("原链表: ");
        printList(a);
        System.out.println("原head: " + a.value);

        Node newHead = reverseListWithCycle(a);
        System.out.println("反转后newHead: " + newHead.value);
        System.out.print("反转后链表: ");
        printList(newHead);
    }
}
