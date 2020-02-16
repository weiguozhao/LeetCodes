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

    def __init__(self):
        self.pre = None

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
                # 先将右子树摘下来
                right = root.right
                # 将左子树放到右子树的位置
                root.right = root.left
                # 原来的左子树置为空
                root.left = None
                # 用一个临时变量去访问原来左子树的最右下的节点
                pre = root.right
                while pre.right is not None:
                    pre = pre.right
                # 原来的右子树挂到原来左子树的最右下节点上
                pre.right = right
                # 从根往下走步
                root = root.right

    def _postorder_travel_recurrent_(self, root: TreeNode) -> None:
        """
        后序遍历改版, 遍历顺序是右子树->左子树->根节点
        https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
        """
        if root is None:
            return
        self._postorder_travel_recurrent_(root.right)
        self._postorder_travel_recurrent_(root.left)
        root.right = self.pre
        root.left = None
        self.pre = root

    def _postorder_travel_foreach_(self, root: TreeNode) -> None:
        to_visit = []
        curr, pre = root, None
        while curr is not None or len(to_visit) > 0:
            # 后序遍历先将所有的最右节点加入到stack中
            while curr is not None:
                to_visit.append(curr)
                curr = curr.right
            # stack中取一个元素
            curr = to_visit[-1]
            # 在不存在左子树或者右子树已经访问过的情况下, 访问根
            if curr.left is None or curr.left == pre:
                to_visit.pop()

                curr.right = pre
                curr.left = None

                pre = curr
                curr = None
            # 访问左子树
            else:
                curr = curr.left


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    Solution()._postorder_travel_foreach_(root)
    while root:
        print(root.val, end=" ")
        root = root.right
