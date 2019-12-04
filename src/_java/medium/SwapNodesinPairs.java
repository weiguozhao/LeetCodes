package _java.medium;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-18
 */
public class SwapNodesinPairs {
    /**
     * problem 24
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     *
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode feakHead = new ListNode(0);
        feakHead.next = head;

        ListNode first = head, last = head.next, pre = feakHead;
        while(last != null){
            first.next = last.next;
            last.next = first;
            pre.next = last;

            pre = first;
            first = first.next;
            if (first != null){
                last = first.next;
            } else {
                break;
            }
        }
        return feakHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = new SwapNodesinPairs().swapPairs(head);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
