# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 234
    https://leetcode-cn.com/problems/palindrome-linked-list

    请判断一个链表是否为回文链表。

    示例 1:
    输入: 1->2
    输出: false

    示例 2:
    输入: 1->2->2->1
    输出: true

    进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    """

    def isPalindrome(self, head: ListNode) -> bool:
        return self._stack_(head)

    def _stack_(self, head: ListNode) -> bool:
        length = 0
        point = head
        while point:
            length += 1
            point = point.next
        half = length // 2
        stack = []
        point = head
        while half > 0:
            stack.append(point)
            point = point.next
            half -= 1
        if length % 2 == 1:
            point = point.next

        while point and stack:
            if stack[-1].val != point.val:
                return False
            point = point.next
            stack.pop()

        if point or stack:
            return False
        else:
            return True

    def _optimize_(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return True

        # 先用快慢指针找到中间的链表节点slow，
        fast, slow = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # 再对slow后面的链表原地反转
        node = slow.next
        slow.next = None
        cur_node, pre_node, next_node = node, None, None
        while cur_node:
            next_node = cur_node.next
            cur_node.next = pre_node
            pre_node = cur_node
            cur_node = next_node

        # 依次比较反转后的链表和初始链表在slow之前的链表的值
        point = head
        while pre_node:
            if point.val != pre_node.val:
                return False
            pre_node = pre_node.next
            point = point.next

        return True


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(1)
    res = Solution().isPalindrome(head)
    print(res)
