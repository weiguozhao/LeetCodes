package _java.medium;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class RemoveDuplicatesfromSortedList_II {
    /**
     * problem 82
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * <p>
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * <p>
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */

    /**
     * 依旧是快慢指针的思想
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 增加头节点方便操作
        ListNode p = new ListNode(-1);
        p.next = head;

        // tail是结果的尾指针
        // last、front是两个相邻的节点，根据二者是否相等判断是否将节点加入到结果中
        ListNode tail = p, last = head, front = head.next;
        while (front != null) {
            if (last.val != front.val) {
                tail.next = last;
                tail = tail.next;
                last = front;
                front = front.next;
            } else {
                while (front != null && front.val == last.val) {
                    front = front.next;
                }
                last = front;
                if (front != null) {
                    front = front.next;
                }
            }
        }

        if (last != null) {
            last.next = null;
        }
        tail.next = last;
        return p.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode res = new RemoveDuplicatesfromSortedList_II().deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
