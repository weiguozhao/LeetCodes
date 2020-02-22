# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 206
    https://leetcode-cn.com/problems/reverse-linked-list/

    反转一个单链表。

    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL

    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    """

    def reverseList(self, head: ListNode) -> ListNode:
        return self._foreach_(head)

    def _foreach_(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return None

        new_head = ListNode(0)
        new_head.next = head

        while head.next:
            node = head.next
            head.next = node.next
            node.next = new_head.next
            new_head.next = node

        return new_head.next

    def _recurrent_(self, head: ListNode) -> ListNode:
        """
        假设链表：n(1) → ... → n(k−1) → n(k) → n(k+1) → ... → n(m) → None
        若从节点 n(k+1) 到 n(m) 已经被反转，而我们正处于 n(k)。

        n(1) → ... → n(k−1) → n(k) → n(k+1) ← ... ← n(m)

        我们希望 n(k+1) 的下一个节点指向 n(k)。
        所以，n(k).next.next = n(k)。

        要小心的是 n(1) 的下一个必须指向 None。
        如果忽略了这一点，你的链表中可能会产生循环。
        如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
        """
        if head is None or head.next is None:
            return None

        node = self._recurrent_(head.next)
        head.next.next = head
        head.next = None
        return node


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    res = Solution().reverseList(head)
    while res:
        print(res.val, end=" ")
        res = res.next
