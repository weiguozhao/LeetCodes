package javalanguage.easy;

import javalanguage.utils.ListNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author zhaoweiguo
 * @date 2019-09-20
 */
public class RemoveDuplicatesfromSortedList {
    /**
     * problem 83
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pHead = head;
        while(pHead.next != null){
            if(pHead.val == pHead.next.val){
                pHead.next = head.next.next;
            } else {
                pHead = pHead.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        head.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode res = new RemoveDuplicatesfromSortedList().deleteDuplicates(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
