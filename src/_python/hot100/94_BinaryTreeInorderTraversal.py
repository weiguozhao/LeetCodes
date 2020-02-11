# coding:utf-8

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 94
    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

    给定一个二叉树，返回它的中序遍历。

    示例:
    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,3,2]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    """

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.ans = []
        self._inorder_travel2_(root)
        return self.ans

    def _inorder_travel2_(self, root: TreeNode) -> None:
        stack = []
        node = root
        while len(stack) > 0 or node is not None:
            while node is not None:
                stack.append(node)
                node = node.left

            node = stack.pop()
            self.ans.append(node.val)
            node = node.right

    def _inorder_travel_(self, root: TreeNode) -> None:
        if root is None:
            return

        if root.left is not None:
            self._inorder_travel_(root.left)

        self.ans.append(root.val)

        if root.right is not None:
            self._inorder_travel_(root.right)


if __name__ == '__main__':
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    res = Solution().inorderTraversal(root)

    print(res)
