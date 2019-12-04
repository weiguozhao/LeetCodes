package _java.medium;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-11-28
 */
public class RotateList {
    /**
     * problem 61
     * https://leetcode-cn.com/problems/rotate-list/
     * <p>
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * <p>
     * 示例 2:
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode last = head;
        while (last != null) {
            last = last.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }

        int steps = length - k;
        ListNode front = head;
        last = front;
        while (steps-- != 0) {
            last = front;
            front = front.next;
        }

        last.next = null;
        // 暂存结果的指针
        last = front;
        while (front.next != null) {
            front = front.next;
        }
        front.next = head;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 3;

        ListNode res = new RotateList().rotateRight(head, n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
