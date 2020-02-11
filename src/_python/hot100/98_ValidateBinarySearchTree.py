# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 98

    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    假设一个二叉搜索树具有如下特征：
        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。

    示例 1:
    输入:
        2
       / \
      1   3
    输出: true

    示例 2:
    输入:
        5
       / \
      1   4
         / \
        3   6
    输出: false
    解释: 输入为: [5,1,4,null,null,3,6]。
         根节点的值为 5 ，但是其右子节点值为 4 。
    """

    def isValidBST(self, root: TreeNode) -> bool:
        return self._inorder_travel_(root)

    def _inorder_travel3_(self, root: TreeNode) -> bool:
        stack, inorder = [], float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            # If next element in inorder traversal
            # is smaller than the previous one
            # that's not BST.
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right
        return True

    def _inorder_travel2_(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = [(root, float('-inf'), float('inf')), ]
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            val = root.val
            if val <= lower or val >= upper:
                return False
            stack.append((root.right, val, upper))
            stack.append((root.left, lower, val))
        return True

    def _inorder_travel_(self, root: TreeNode, lower: float = float('-inf'), upper: float = float('inf')) -> bool:
        if not root:
            return True
        val = root.val
        if lower >= val or val >= upper:
            return False
        if not self._inorder_travel_(root.left, lower, val):
            return False
        if not self._inorder_travel_(root.right, val, upper):
            return False
        return True


if __name__ == '__main__':
    root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right.left = TreeNode(3)
    root.right.right = TreeNode(6)

    root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)

    res = Solution().isValidBST(root2)
    print(res)
