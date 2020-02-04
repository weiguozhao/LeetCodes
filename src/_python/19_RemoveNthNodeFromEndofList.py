# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 19
    https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    """
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 特判
        if not head or (not head.next and n == 1):
            return None

        # fast_point先走n步
        fast_point = head
        while n != 0 and fast_point:
            fast_point = fast_point.next
            n -= 1

        # 快慢指针之间相隔n-1个节点
        slow_point = head

        # 控制fast_point指向最后一个节点，则慢指针指向待删除节点的上一个节点
        while fast_point and fast_point.next:
            fast_point = fast_point.next
            slow_point = slow_point.next

        if not fast_point:
            # 当fast_point指向空的时候，说明要删除第一个节点
            head = head.next
        else:
            # 正常情况下的删除节点
            slow_point.next = slow_point.next.next

        return head


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    res = Solution().removeNthFromEnd(head, 2)

    while res:
        print(res.val)
        res = res.next
