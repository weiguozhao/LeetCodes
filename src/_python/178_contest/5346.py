# coding:utf-8


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 5346
    https://leetcode-cn.com/contest/weekly-contest-178/problems/linked-list-in-binary-tree/

    给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
    如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
    那么请你返回 True ，否则返回 False 。
    一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。

    示例 1：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/sample_1_1720.png
    输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
    输出：true
    解释：树中蓝色的节点构成了与链表对应的子路径。

    示例 2：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/sample_2_1720.png
    输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
    输出：true

    示例 3：
    输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
    输出：false
    解释：二叉树中不存在一一对应链表的路径。

    提示：
    二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
    链表包含的节点数目在 1 到 100 之间。
    二叉树包含的节点数目在 1 到 2500 之间。
    """

    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        queue = [root]
        while queue:
            node = queue.pop(0)
            if node is None:
                continue
            queue.append(node.left)
            queue.append(node.right)

            if node.val == head.val:
                if self._dfs_(head, node):
                    return True

        return False

    def _dfs_(self, head: ListNode, root: TreeNode) -> bool:
        if head is None:
            return True
        if root is None:  # head is not None and root is None
            return False

        if head.val == root.val:
            if self._dfs_(head.next, root.left):
                return True
            if self._dfs_(head.next, root.right):
                return True
        return False


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(4)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(6)

    root = TreeNode(1)
    root.left = TreeNode(4)
    root.left.right = TreeNode(2)
    root.left.right.left = TreeNode(1)

    root.right = TreeNode(4)
    root.right.left = TreeNode(2)
    root.right.left.left = TreeNode(6)
    root.right.left.right = TreeNode(8)
    root.right.left.right.left = TreeNode(1)
    root.right.left.right.right = TreeNode(3)

    res = Solution().isSubPath(head, root)
    print(res)
