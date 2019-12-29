package _java.hard;

import _java.utils.ListNode;

/**
 * @author zhaoweiguo
 * @date 2019-12-17
 */
public class ReverseNodesink_Group {
    /**
     * problem 25
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     *
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例 :
     * 给定这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明 :
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * */

    /**
     * 简单的思路：每遇到 k 个节点，将这 k 个节点 reverse 再插入到链表中
     * time: O(Nk)
     * space: O(1)
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;

        ListNode previous, last = pHead;
        int count = 0;
        while (last != null) {
            previous = last;
            last = last.next;
            count++;

            while (last != null && count % k != 0) {
                last = last.next;
                count++;
            }

            // 有可能 last == null 和 count % k == 0 同时成立
            if (count % k == 0 && last != null) {
                ListNode newTailNode = previous.next;
                ListNode newTailNextNode = last.next;
                previous.next = reverse(previous.next, last);
                newTailNode.next = newTailNextNode;
                last = newTailNode;
            }
        }
        
        return pHead.next;
    }

    private ListNode reverse(ListNode previous, ListNode last) {
        // 带有头节点的头插
        ListNode head = new ListNode(0);
        while (previous != last) {
            ListNode temp = previous.next;
            previous.next = head.next;
            head.next = previous;
            previous = temp;
        }
        last.next = head.next;
        head.next = last;
        return head.next;
    }

    /**
     * 思路：递归解决相似问题
     * time: O(Nk)
     * space: O(1)
     * */
    public ListNode reverseKGroupDirect(ListNode head, int k) {
        if(head == null){
            return null;
        }

        int count = 0;
        ListNode S = head, temp = head;
        // 第一个group
        while(temp != null && ++count < k){
            temp = temp.next;
        }

        // 足够k个值
        if(count == k){
            count = 0;
            ListNode pro = null;
            ListNode next = head.next;
            // 翻转当前的group
            while(++count < k){
                head.next = pro;
                pro = head;
                head = next;
                next = next.next;
            }
            // 翻转后的结果插入到链表中
            head.next = pro;
            pro = head;
            head = next;
            // 相同的问题，递归解决
            S.next = reverseKGroup(head,k);
            // 返回翻转后group的链表head
            return pro;
        }

        // 不够k个值，直接返回原结果
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = new ReverseNodesink_Group().reverseKGroupDirect(head, 2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
