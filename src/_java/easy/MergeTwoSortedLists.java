package _java.easy;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */


public class MergeTwoSortedLists {
    /**
     * problem 21.
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     *
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //注意边界条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode tl1 = l1;
        ListNode tl2 = l2;

        ListNode res = new ListNode(-1);
        ListNode point = res;
        while (tl1 != null && tl2 != null) {
            if (tl1.val > tl2.val) {
                point.next = tl2;
                tl2 = tl2.next;
            } else {
                point.next = tl1;
                tl1 = tl1.next;
            }
            point = point.next;
        }

//        while (tl1 != null) {
//            point.next = tl1;
//            tl1 = tl1.next;
//            point = point.next;
//        }
//        while (tl2 != null) {
//            point.next = tl2;
//            tl2 = tl2.next;
//            point = point.next;
//        }
        point.next = tl1 == null ? tl2 : tl1;
        return res.next;
    }

    /**
     * 注意题目条件：
     * 有序链表
     *
     * 注意边界条件：
     * 当l1或者l2其中一个为空的时候；都为空的时候
     *
     * 三元语法减少代码量
     * */

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = null;

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        list2.next.next.next = null;

        ListNode res = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        while (res.next != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
