# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    problem 114
    https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/

    给定一个二叉树，原地将它展开为链表。
    例如，给定二叉树

        1
       / \
      2   5
     / \   \
    3   4   6
    将其展开为：

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
    """

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # 用右指针表示链表的next
        while root:
            # 左子树为空，往右子树走
            if root.left is None:
                root = root.right
            else:
                # 左子树不为空
                pre = root.left
                # 找到左子树的最右下节点
                while pre.right is not None:
                    pre = pre.right
                # 原来的右子树挂到左子树最右下
                pre.right = root.right
                # 原来的左子树挂到根的右子树
                root.right = root.left
                # 原来的左子树置为空
                root.left = None
                # 往右下走一步
                root = root.right

    def _postorder_travel_(self, root: TreeNode) -> None:
        """
        后序遍历改版
        https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
        """
        to_visit = []
        curr, pre = root, None
        while curr is not None or len(to_visit) > 0:

            while curr is not None:
                to_visit.append(curr)
                curr = curr.right

            curr = to_visit[-1]
            if curr.left is None or curr.left == pre:
                to_visit.pop()

                curr.right = pre
                curr.left = None

                pre = curr
                curr = None

            else:
                curr = curr.left


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    Solution().flatten(root)
    while root:
        print(root.val, end=" ")
        root = root.right
