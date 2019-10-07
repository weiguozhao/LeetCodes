package javalanguage.medium;

import javalanguage.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class AddTwoNumbers {
    /**
     * problem 2
     * https://leetcode-cn.com/problems/add-two-numbers/
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
