# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    problem 141
    https://leetcode-cn.com/problems/linked-list-cycle/

    给定一个链表，判断链表中是否有环。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。

    示例 1：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png
    输入：head = [3,2,0,-4], pos = 1
    输出：true
    解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png
    输入：head = [1,2], pos = 0
    输出：true
    解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png
    输入：head = [1], pos = -1
    输出：false
    解释：链表中没有环。

    进阶：
    你能用 O(1)（即，常量）内存解决此问题吗？
    """

    def hasCycle(self, head: ListNode) -> bool:
        if not head or not head.next:
            return False

        slow, fast = head, head.next
        while not (slow == fast or fast is None):
            slow = slow.next
            fast = fast.next
            if fast is not None:
                fast = fast.next

        if slow == fast:
            return True
        else:
            return False


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = head

    res = Solution().hasCycle(head)
    print(res)
