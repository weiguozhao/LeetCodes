# coding:utf-8


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    """
    problem 297
    https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
    同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
    你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

    示例: 
    你可以将以下二叉树：

        1
       / \
      2   3
         / \
        4   5
    序列化为 "[1,2,3,null,null,4,5]"

    提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
          你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
    """

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        res = []
        current_layer = []
        if root:
            current_layer.append(root)

        while current_layer:
            next_layer = []
            for node in current_layer:
                if node:
                    res.append(str(node.val))
                    next_layer.append(node.left)
                    next_layer.append(node.right)
                else:
                    res.append("#")     # '#'表示空节点

            if not next_layer:
                break
            current_layer = next_layer[:]

        return ",".join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None

        data = data.split(",")
        root = TreeNode(data[0])
        current_layer, index = [root], 1
        while current_layer:
            next_layer = []
            for node in current_layer:
                left_val = data[index]
                index += 1
                if left_val != "#":
                    node.left = TreeNode(int(left_val))
                    next_layer.append(node.left)

                right_val = data[index]
                index += 1
                if right_val != "#":
                    node.right = TreeNode(int(right_val))
                    next_layer.append(node.right)

            if not next_layer:
                break
            current_layer = next_layer[:]

        return root


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(5)

    code = Codec()
    serial = code.serialize(root)
    print(serial)

    reroot = code.deserialize(serial)

