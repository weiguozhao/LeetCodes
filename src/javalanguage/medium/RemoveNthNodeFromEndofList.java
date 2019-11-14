package javalanguage.medium;

import javalanguage.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-16
 */
public class RemoveNthNodeFromEndofList {
    /**
     * problem 19
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     */
    /**
     * 没有头节点，操作起来很麻烦
     */
    public ListNode removeNthFromEndWithoutHeadNode(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        ListNode res = head, tail = head;
        while (n-- != 0) {
            tail = tail.next;
        }
        while (tail != null && tail.next != null) {
            head = head.next;
            tail = tail.next;
        }
        if (tail == null) {
            res = head.next;
        } else {
            head.next = head.next.next;
        }
        return res;
    }

    /**
     * 增加一个头节点，方便处理需要释放第一个节点
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode res = new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
