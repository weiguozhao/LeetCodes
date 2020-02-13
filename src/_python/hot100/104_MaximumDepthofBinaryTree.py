# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 104
    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明: 叶子节点是指没有子节点的节点。

    示例：
    给定二叉树 [3,9,20,null,null,15,7]，

        3
       / \
      9  20
        /  \
       15   7
    返回它的最大深度 3 。
    """

    def maxDepth(self, root: TreeNode) -> int:
        return self._dfs_(root)

    def _dfs_(self, root: TreeNode) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1

        left_depth = self._dfs_(root.left)
        right_depth = self._dfs_(root.right)
        return max(left_depth, right_depth) + 1


if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    res = Solution().maxDepth(root)
    print(res)
