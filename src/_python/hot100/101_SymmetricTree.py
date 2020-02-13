# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    给定一个二叉树，检查它是否是镜像对称的。

    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
       / \
      2   2
     / \ / \
    3  4 4  3

    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
       / \
      2   2
       \   \
       3    3
    """

    def isSymmetric(self, root: TreeNode) -> bool:
        # 递归: 深度遍历
        # return self._recurrent_(root, root)
        # 循环: 层序遍历
        return self._foreach_(root)

    def _recurrent_(self, r1: TreeNode, r2: TreeNode) -> bool:
        if r1 is None and r2 is None:
            return True
        if r1 is None or r2 is None:
            return False

        if r1.val == r2.val:
            return self._recurrent_(r1.left, r2.right) and self._recurrent_(r1.right, r2.left)

        return False

    def _foreach_(self, root: TreeNode) -> bool:
        queue = [root]

        while len(queue) > 0:
            next_queue = []
            layer = []
            for node in queue:
                if node is None:
                    layer.append(None)
                    continue

                next_queue.append(node.left)
                next_queue.append(node.right)
                layer.append(node.val)

            if layer != layer[::-1]:
                return False
            # next layer
            queue = next_queue

        return True


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)

    root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(2)
    root2.left.right = TreeNode(3)
    root2.right.right = TreeNode(3)

    res = Solution().isSymmetric(root)
    print(res)
