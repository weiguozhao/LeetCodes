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
    https://leetcode-cn.com/contest/weekly-contest-180/problems/balance-a-binary-search-tree/

    给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
    如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
    如果有多种构造方法，请你返回任意一种。

    示例：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/15/1515_ex1_out.png
    输入：root = [1,null,2,null,3,null,4,null,null]
    输出：[2,1,3,null,null,null,4]
    解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。

    提示：
    树节点的数目在 1 到 10^4 之间。
    树节点的值互不相同，且在 1 到 10^5 之间。
    """

    def balanceBST(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        self.nodes = []
        self._inorder_travel_(root)
        mid = len(self.nodes) // 2
        root = self.nodes[mid]
        root.left = self._binary_build_tree_(self.nodes[:mid])
        root.right = self._binary_build_tree_(self.nodes[mid + 1:])
        return root

    def _binary_build_tree_(self, nodes: List[TreeNode]) -> TreeNode:
        length = len(nodes)
        if length == 0:
            return None
        else:
            mid = length // 2
            root = nodes[mid]
            root.left = self._binary_build_tree_(nodes[:mid])
            root.right = self._binary_build_tree_(nodes[mid + 1:])
            return root

    def _inorder_travel_(self, root: TreeNode) -> None:
        if not root:
            return

        if root.left:
            self._inorder_travel_(root.left)

        self.nodes.append(root)

        if root.right:
            self._inorder_travel_(root.right)


if __name__ == '__main__':
    pass
