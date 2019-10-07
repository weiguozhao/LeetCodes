package javalanguage.easy;

import javalanguage.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class RemoveLinkedListElements {
    /**
     * problem 203
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
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