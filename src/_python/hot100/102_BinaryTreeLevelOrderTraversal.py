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
    problem 102
    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

    例如:
    给定二叉树: [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    返回其层次遍历结果：

    [
      [3],
      [9,20],
      [15,7]
    ]
    """

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        ans = []

        queue = [root]
        while len(queue) > 0:
            next_queue = []
            values = []
            for node in queue:
                if node is None:
                    continue

                next_queue.append(node.left)
                next_queue.append(node.right)
                values.append(node.val)

            queue = next_queue
            if len(values) > 0:
                ans.append(values.copy())

        return ans


if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    res = Solution().levelOrder(root)
    print(res)
