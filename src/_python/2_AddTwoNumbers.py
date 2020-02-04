# coding: utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 2: 两数相加
    https://leetcode-cn.com/problems/add-two-numbers/

    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照"逆序"的方式存储的，并且它们的每个节点只能存储"一位"数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    """

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        p = head
        carry = 0
        while l1 is not None or l2 is not None:
            n1, n2 = 0, 0
            if l1 is not None:
                n1 = l1.val
                l1 = l1.next
            if l2 is not None:
                n2 = l2.val
                l2 = l2.next

            val = (n1 + n2 + carry) % 10
            carry = (n1 + n2 + carry) // 10
            p.next = ListNode(val)
            p = p.next

        if carry != 0:
            p.next = ListNode(carry)

        return head.next


if __name__ == "__main__":
    solution = Solution()

    num1 = ListNode(2)
    num1.next = ListNode(4)
    num1.next.next = ListNode(3)

    num2 = ListNode(5)
    num2.next = ListNode(6)
    num2.next.next = ListNode(4)

    res = solution.addTwoNumbers(num1, num2)
    while res is not None:
        print(res.val)
        res = res.next
