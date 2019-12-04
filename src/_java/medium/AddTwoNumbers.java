package _java.medium;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class AddTwoNumbers {
    /**
     * problem 2
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, add;
        ListNode res = new ListNode(-1);
        ListNode point = res;
        while (l1 != null && l2 != null) {
            add = l1.val + l2.val + carry;

            point.next = new ListNode(add % 10);
            carry = add / 10;

            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        ListNode rest = l1 == null ? l2 : l1;
        while (rest != null) {
            add = rest.val + carry;

            point.next = new ListNode(add % 10);
            carry = add / 10;

            rest = rest.next;
            point = point.next;
        }

        if (carry != 0){
            point.next = new ListNode(carry);
        }

        return res.next;
    }

    public static void main(String[] args) {

    }
}
