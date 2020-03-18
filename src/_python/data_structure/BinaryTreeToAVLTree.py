# coding:utf-8

from typing import Dict

"""
problem 5179 将二叉搜索树变平衡
https://leetcode-cn.com/problems/balance-a-binary-search-tree/
"""


class TreeNode:
    def __init__(self, value=None):
        self.val = value
        self.left = None
        self.right = None


def show_layer_tree(root: TreeNode) -> None:
    """层序遍历输出"""
    if root is None:
        print("#")
        return

    current_layer = [root]
    ans = []
    while current_layer:
        next_layer = []
        has_element = False
        line = ""
        for node in current_layer:
            if node is None:
                next_layer.append(None)
                next_layer.append(None)
                line += "#\t"
            else:
                has_element = True
                next_layer.append(node.left)
                next_layer.append(node.right)
                line += str(node.val) + "\t"
        if not has_element:
            break
        ans.append(line)
        current_layer = next_layer[:]

    layers = len(ans)
    for i in range(layers):
        print(ans[i])


def _rotate_right_(root: TreeNode, node_height: Dict[TreeNode, int]) -> TreeNode:
    """
         3              2
        /             /  \
       2    右旋变成  1   3
      /
     1
    """
    left = root.left
    root.left = left.right
    left.right = root

    height = node_height.get(left, 0)
    node_height[left] = height + 1
    height = node_height.get(root, 0)
    node_height[root] = height - 1

    return left


def _rotate_left_(root: TreeNode, node_height: Dict[TreeNode, int]) -> TreeNode:
    """
        1                  2
         \               /  \
          2    左旋变成  1    3
          \
           3
    """
    right = root.right
    root.right = right.left
    right.left = root

    height = node_height.get(right, 0)
    node_height[right] = height + 1
    height = node_height.get(root, 0)
    node_height[root] = height - 1

    return right


def insert(root: TreeNode, val: int, node_height: Dict[TreeNode, int]) -> TreeNode:
    if not root:
        # 从空树开始，这里开始建立root节点
        root = TreeNode(val)
        node_height[root] = 1
        return root

    node = root
    if val < node.val:
        # 要插入到左子树
        node.left = insert(root.left, val, node_height)
        if node_height.get(node.left, 0) - node_height.get(node.right, 0) > 1:
            if val > node.left.val:
                """
                     3
                    /
                   1
                    \
                     2
                这种要先左旋再右旋
                """
                node.left = _rotate_left_(node.left, node_height)
            """
                   3
                  /
                 2
                /
               1
            这种直接右旋
            """
            node = _rotate_right_(node, node_height)
    elif val > node.val:
        # 要插入到右子树
        node.right = insert(root.right, val, node_height)
        if node_height.get(node.right, 0) - node_height.get(node.left, 0) > 1:
            if val < node.right.val:
                """
                1
                 \
                  3
                 /
                2
                这种要先右旋再左旋
                """
                node.right = _rotate_right_(node.right, node_height)

            """
            1
             \
              3
               \
                4
            这种直接左旋
            """
            node = _rotate_left_(node, node_height)
    else:
        # 要插入的值和root相同
        return node

    height = max(node_height.get(node.left, 0), node_height.get(node.right, 0)) + 1
    node_height[node] = height
    return node


def balanceBST(root: TreeNode) -> TreeNode:
    if root is None:
        return None

    node_height = {}
    new_root = None
    stack = []
    node = root
    # 迭代版先序遍历树
    while node or stack:
        if node is not None:
            # 非空节点插入到之后的AVL树中
            new_root = insert(new_root, node.val, node_height)
            stack.append(node)
            node = node.left
        else:
            node = stack.pop(0)
            node = node.right
    return new_root


if __name__ == '__main__':
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.right = TreeNode(3)
    root.right.right.right = TreeNode(4)

    show_layer_tree(root)
    print("-" * 10, "after", "-" * 10)
    root = balanceBST(root)
    show_layer_tree(root)
