# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 21
    https://leetcode-cn.com/problems/merge-two-sorted-lists/

    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
    """

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        pNode = head

        # 两个链表相同长度的部分
        while l1 and l2:
            if l1.val < l2.val:
                pNode.next = l1
                l1 = l1.next
            else:
                pNode.next = l2
                l2 = l2.next

            pNode = pNode.next

        # 多出的部分
        pNode.next = l1 if not l2 else l2
        return head.next


if __name__ == '__main__':
    l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next.next = ListNode(4)

    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)

    res = Solution().mergeTwoLists(l1, l2)
    while res:
        print(res.val)
        res = res.next
