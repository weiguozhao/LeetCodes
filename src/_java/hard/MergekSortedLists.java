package _java.hard;

import _java.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhaoweiguo
 * @date 2019-12-16
 */
public class MergekSortedLists {
    /**
     * problem 23
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * <p>
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

    /**
     * 归并排序
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >>> 1;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode pHead = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pHead.next = list1;
                list1 = list1.next;
            } else {
                pHead.next = list2;
                list2 = list2.next;
            }
            pHead = pHead.next;
        }
        if (list1 != null) {
            pHead.next = list1;
        } else {
            pHead.next = list2;
        }

        return head.next;
    }


    /**
     * 借助优先队列完成合并
     * time: O(N log k)
     * - 弹出操作时，比较操作的代价会被优化到 O(log k)。同时，找到最小值节点的时间开销仅仅为 O(1)。
     * - 最后的链表中总共有 N 个节点。
     * space: O(k)
     */
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
            lists[i] = lists[i].next;
        }
        while (!priorityQueue.isEmpty()) {
            ListNode p = priorityQueue.poll();
            if (p.next != null) {
                priorityQueue.add(p.next);
            }

            point.next = p;
            point = point.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode res = new MergekSortedLists().mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
