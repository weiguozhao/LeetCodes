# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 226
    https://leetcode-cn.com/problems/invert-binary-tree/

    翻转一棵二叉树。

    示例：
        输入：

             4
           /   \
          2     7
         / \   / \
        1   3 6   9

        输出：

             4
           /   \
          7     2
         / \   / \
        9   6 3   1
    """

    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None

        right = self.invertTree(root.left)
        left = self.invertTree(root.right)
        root.left = left
        root.right = right
        return root

if __name__ == '__main__':
    pass
