# coding:utf-8

import sys


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 124
    https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/

    给定一个非空二叉树，返回其最大路径和。
    本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

    示例 1:
    输入: [1,2,3]

           1
          / \
         2   3

    输出: 6

    示例 2:
    输入: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    输出: 42
    """

    def maxPathSum(self, root: TreeNode) -> int:
        self.ans = - sys.maxsize - 1
        self._max_value_(root)
        return int(self.ans)

    def _max_value_(self, root: TreeNode) -> int:
        if root is None:
            return 0

        left_max = max(self._max_value_(root.left), 0)
        right_max = max(self._max_value_(root.right), 0)
        value = root.val

        max_value = max(value, value + left_max, value + right_max, value + left_max + right_max)
        self.ans = max(self.ans, max_value)
        # 经过root的路径只能有三种情况:
        # 1. 到root停止
        # 2. 走root的左子树
        # 3. 走root的右子树
        return max(value, value + left_max, value + right_max)


if __name__ == '__main__':
    root = TreeNode(-10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    res = Solution().maxPathSum(root)
    print(res)
