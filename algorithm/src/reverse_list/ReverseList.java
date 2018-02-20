package reverse_list;

/**
 * 链表反转，递归，非递归
 */

import java.util.Scanner;

/**
 * 定义Node
 */
class Node {
    // 结点值
    int value;
    // 下一结点
    Node next = null;

    Node(int value) {
        this.value = value;
    }
}

public class ReverseList {
    // 递归
    private static Node recuisiveMethod(Node head) {
        // 递归出口，head为null或单个结点或尾结点
        if (head == null || head.next == null) {
            return head;
        }
        // 递归直至返回尾结点
        Node newHead = recuisiveMethod(head.next);
        // 反转链表指针
        head.next.next = head;
        // 原指针指向null
        head.next = null;
        // 每次返回相同的尾结点
        return newHead;
    }

    // 非递归
    private static Node nonRecursiveMethod(Node head) {
        Node prev = null;
        while (head != null) {
            // 保存下一结点
            Node temp = head.next;
            // 反转head指针
            head.next = prev;
            // 更新prev
            prev = head;
            // 更新head
            head = temp;
        }
        // while结束时head为null，返回prev
        return prev;
    }

    // 打印链表
    private static void printList(Node head) {
        // 保存头结点
        Node p = head;
        while (p != null) {
            System.out.print(p.value);
            if (p.next != null) {
                System.out.print(" -> ");
            }
            p = p.next;
        }
    }

    // 创建n个结点的链表，返回头结点
    private static Node createList(int n) {
        if (n < 1) {
            return null;
        }
        Scanner cin = new Scanner(System.in);
        Node head = null, p = null;
        System.out.print("\n输入" + n + "个结点值:");
        for (int i = 0; i < n; i++) {
            if (head == null) { // 头结点
                head = new Node(cin.nextInt());
                p = head; // 第一次输入数据时p指向头结点
                continue;
            }
            // 之后每次输入数据指向下一结点
            p.next = new Node(cin.nextInt());
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 创建链表
        Scanner cin = new Scanner(System.in);
        System.out.print("输入一个整数n:");
        int n = cin.nextInt();
        Node head = createList(n);
        // 原链表
        System.out.print("原链表list：");
        printList(head);
        System.out.print("\n递归反转链表list得到list1：");
        Node newHead = recuisiveMethod(head);
        printList(newHead);
        System.out.print("\n非递归反转链表list1得到list2：");
        head = newHead;
        Node anotherHead = nonRecursiveMethod(head);
        printList(anotherHead);
    }
}
