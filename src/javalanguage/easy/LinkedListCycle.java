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
     *
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
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
