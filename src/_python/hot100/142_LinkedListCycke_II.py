# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    """
    problem 142
    https://leetcode-cn.com/problems/linked-list-cycle-ii/

    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。

    示例 1：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png
    输入：head = [3,2,0,-4], pos = 1
    输出：tail connects to node index 1
    解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png
    输入：head = [1,2], pos = 0
    输出：tail connects to node index 0
    解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png
    输入：head = [1], pos = -1
    输出：no cycle
    解释：链表中没有环。

    进阶：
    你是否可以不用额外空间解决此题？
    """
    def detectCycle(self, head: ListNode) -> ListNode:
        """
        1. 判断有没有环
        2. 环的长度length
        3. 从head开始快慢指针
        """
        if not head or not head.next:
            return None

        slow, fast = head, head.next
        while not (slow == fast or fast is None):
            slow = slow.next
            fast = fast.next
            if fast is not None:
                fast = fast.next
        # 没有环
        if fast is None:
            return None

        fast = slow.next
        length = 1
        while slow != fast:
            fast = fast.next
            length += 1

        slow, fast = head, head
        while length > 0:
            fast = fast.next
            length -= 1
        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow


if __name__ == '__main__':
    head = ListNode(3)
    head.next = ListNode(2)
    head.next.next = ListNode(0)
    head.next.next.next = ListNode(-4)
    head.next.next.next.next = head.next

    res = Solution().detectCycle(head)
    print(res.val)
