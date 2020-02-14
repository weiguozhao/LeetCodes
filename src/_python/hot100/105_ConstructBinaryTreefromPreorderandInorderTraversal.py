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
    problem 105
    https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    根据一棵树的前序遍历与中序遍历构造二叉树。
    注意:
    你可以假设树中没有重复的元素。

    例如，给出
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]

    返回如下的二叉树：
        3
       / \
      9  20
        /  \
       15   7
    """

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) <= 0:
            return None
        if len(preorder) == 1:
            return TreeNode(preorder[0])

        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:index + 1], inorder[:index])
        root.right = self.buildTree(preorder[index + 1:], inorder[index + 1:])
        return root


if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    layerorder = [3, 9, 20, 15, 7]

    res = Solution().buildTree(preorder, inorder)
    import queue

    q = queue.Queue()
    q.put(res)
    while not q.empty():
        node = q.get()
        if node is None:
            continue

        print(node.val, end=" ")
        q.put(node.left)
        q.put(node.right)
