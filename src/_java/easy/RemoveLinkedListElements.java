package _java.easy;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class RemoveLinkedListElements {
    /**
     * problem 203
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     *
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode first = head, tail = head.next;
        while (tail != null) {
            if (tail.val == val) {
                first.next = tail.next;
            } else {
                first = tail;
            }
            tail = tail.next;
        }

        // 修正第一个元素为val的情况 / 结果为空的情况
        if (head.val == val) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
