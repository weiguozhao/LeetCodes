# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 148
    https://leetcode-cn.com/problems/sort-list/

    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

    示例 1:
    输入: 4->2->1->3
    输出: 1->2->3->4

    示例 2:
    输入: -1->5->3->4->0
    输出: -1->0->3->4->5
    """

    def sortList(self, head: ListNode) -> ListNode:
        """
        time: O(nlogn)
        space: O(n)
        """
        if not head or not head.next:
            return head

        # 找中点
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # 划分链表 [head, mid), [mid, end]
        mid = slow.next
        slow.next = None

        # left_ans, right_ans都是排序后的链表
        left_ans = self.sortList(head)
        right_ans = self.sortList(mid)

        # 合并两个已排序的链表
        ans = p = ListNode(0)
        while left_ans and right_ans:
            if left_ans.val < right_ans.val:
                p.next = left_ans
                left_ans = left_ans.next
            else:
                p.next = right_ans
                right_ans = right_ans.next
        p.next = left_ans if not right_ans else right_ans
        return ans.next

    def sortList_foreach(self, head: ListNode) -> ListNode:
        h, length, intv = head, 0, 1
        # 链表长度
        while h:
            h, length = h.next, length + 1
        res = ListNode(0)
        res.next = head

        # merge the list in different intv.
        while intv < length:
            pre, h = res, res.next
            while h:
                # get the two merge head `h1`, `h2`
                h1, i = h, intv
                while i and h:
                    h, i = h.next, i - 1

                # no need to merge because the `h2` is None.
                if i:
                    break
                h2, i = h, intv

                while i and h:
                    h, i = h.next, i - 1

                # the `c2`: length of `h2` can be small than the `intv`.
                c1, c2 = intv, intv - i

                # merge the `h1` and `h2`.
                while c1 and c2:
                    if h1.val < h2.val:
                        pre.next, h1, c1 = h1, h1.next, c1 - 1
                    else:
                        pre.next, h2, c2 = h2, h2.next, c2 - 1
                    pre = pre.next

                pre.next = h1 if c1 else h2
                while c1 > 0 or c2 > 0:
                    pre, c1, c2 = pre.next, c1 - 1, c2 - 1
                pre.next = h
            intv *= 2

        return res.next


if __name__ == '__main__':
    pass
