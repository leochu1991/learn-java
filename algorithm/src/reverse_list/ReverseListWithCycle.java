package reverse_list;

import java.util.HashMap;
import java.util.Map;

/**
 * 反转带环单链表
 */
public class ReverseListWithCycle {


    // 反转带环单链表
    public static Node reverseListWithCycle(Node head) {
        Node prev = null;
        Node cur = head;
        Map<Integer, Integer> map = new HashMap<>();

        while (cur != null) {
            // 已遍历节点，第一次遍历为1
            int mapValue = map.get(cur.hashCode()) != null ? map.get(cur.hashCode()) : 0;
            map.put(cur.hashCode(), mapValue + 1);
            // cur节点第二次遍历，为环的开始节点
            if (map.get(cur.hashCode()) == 2) {
                // 新建一个节点，防止破坏原来交点的指针，环会断开
                Node newHead = new Node(cur.value);
                newHead.next = prev;
                return newHead;
            }
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
    public static void printList(Node head) {
        Node pHead = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (pHead != null) {

            System.out.print(pHead.value + " ");

            int mapValue = map.get(pHead.hashCode()) != null ? map.get(pHead.hashCode()) : 0;
            map.put(pHead.hashCode(), mapValue + 1);
            if (map.get(pHead.hashCode()) == 2) {
                break;
            }
            pHead = pHead.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
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
