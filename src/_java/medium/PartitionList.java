package _java.medium;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class PartitionList {
    /**
     * problem 86
     * https://leetcode-cn.com/problems/partition-list/
     *
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 示例:
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * */

    /**
     * 用两个头指针分别存储小于x、大于等于x的数据
     * 之后将两个链表连接起来
     * */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);

        ListNode p = smaller, q = bigger;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        smaller.next = q.next;
        bigger.next = null;
        return p.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        ListNode res = new PartitionList().partition(head, x);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
