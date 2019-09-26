package javalanguage.easy;

import javalanguage.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class IntersectionofTwoLinkedLists {
    /**
     * problem 160
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p, q;

        p = headA;
        int listALength = 0;
        while (p != null) {
            listALength++;
            p = p.next;
        }

        q = headB;
        int listBLength = 0;
        while (q != null) {
            listBLength++;
            q = q.next;
        }

        if (listALength > listBLength) {
            return getIntersectionNode(headA, headB, listALength - listBLength);
        } else {
            return getIntersectionNode(headB, headA, listBLength - listALength);
        }
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB, int diffLength) {
        while(diffLength > 0){
            headA = headA.next;
            diffLength--;
        }

        while(headA != null && headB != null){
            if (headA == headB){
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        headA.next.next = intersection;
        headB.next.next.next = intersection;

        ListNode res = new IntersectionofTwoLinkedLists().getIntersectionNode(null, null);
        if (res == null){
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }
    }
}
