# coding:utf-8

import heapq
from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 23
    https://leetcode-cn.com/problems/merge-k-sorted-lists/

    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

    示例:
    输入:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
    输出: 1->1->2->3->4->4->5->6
    """

    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        """
        优先队列法
        :param lists:
        :return:
        """
        # 优先队列
        priority_queue = []
        head = ListNode(0)
        res = head

        # 先把每个链表的第一个元素放进优先队列
        for index, link in enumerate(lists):
            if not link:
                continue
            heapq.heappush(priority_queue, (link.val, index))

        while len(priority_queue) > 0:
            # 取出最小的一个
            _, index = heapq.heappop(priority_queue)
            res.next = lists[index]
            res = res.next

            # 如果当前链表还有元素，继续往优先队列里放
            if lists[index].next:
                lists[index] = lists[index].next
                heapq.heappush(priority_queue, (lists[index].val, index))

        return head.next

    def mergeKListsDivideConquer(self, lists: List[ListNode]) -> ListNode:
        """
        分治法
        :param lists:
        :return:
        """
        return self.mergeTwoPartLists(lists, 0, len(lists) - 1)

    def mergeTwoPartLists(self, lists: List[ListNode], left: int, right: int) -> ListNode:
        if left > right:
            return None

        if left == right:
            return lists[left]

        mid = (left + right) >> 1
        left_res = self.mergeTwoPartLists(lists, left, mid)
        right_res = self.mergeTwoPartLists(lists, mid + 1, right)
        return self.mergeTwoListNodes(left_res, right_res)

    def mergeTwoListNodes(self, list1: ListNode, list2: ListNode) -> ListNode:
        head = ListNode(0)
        point = head

        while list1 and list2:
            if list1.val < list2.val:
                point.next = list1
                list1 = list1.next
            else:
                point.next = list2
                list2 = list2.next

            point = point.next

        point.next = list2 if not list1 else list1
        return head.next


if __name__ == '__main__':
    l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next.next = ListNode(5)

    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)

    l3 = ListNode(2)
    l3.next = ListNode(6)

    lists = [l1, l2, l3]

    res = Solution().mergeKListsDivideConquer(lists)

    while res:
        print(res.val)
        res = res.next
