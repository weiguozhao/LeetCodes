package javalanguage.easy;

import javalanguage.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class LinkedListCycle {
    /**
     * problem 141
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * */

    /**
     * 思路：
     * 快慢指针
     * */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;
        while(slow != fast){
            if (fast.next == null || fast.next.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast == slow;
    }

    /**
     * Hash表方法，每次把访问过的Node保存下来
     * time: O(n)
     * space: O(n)
     * */
    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
