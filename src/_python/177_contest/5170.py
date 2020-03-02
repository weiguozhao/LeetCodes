# coding:utf-8

from typing import List


class Solution:
    """
    二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
    只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
    如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
    注意：节点没有值，本问题中仅仅使用节点编号。

    示例 1：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex1.png
    输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
    输出：true

    示例 2：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex2.png
    输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
    输出：false

    示例 3：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex3.png
    输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
    输出：false

    示例 4：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex4.png
    输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
    输出：false

    提示：
    1 <= n <= 10^4
    leftChild.length == rightChild.length == n
    -1 <= leftChild[i], rightChild[i] <= n - 1
    """

    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        return self.answer(n, leftChild, rightChild)

    def answer(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        from queue import Queue

        # indeg保存所有节点的入度
        indeg = [0] * n
        for u in leftChild:
            if u != -1:
                indeg[u] += 1
        for u in rightChild:
            if u != -1:
                indeg[u] += 1
        # 找根节点
        root = -1
        for i in range(n):
            if indeg[i] == 0:
                root = i
                break
        if root == -1:
            return False

        seen = set()
        q = Queue()
        # 用dfs或bfs访问树，有效的二叉树所有的节点会恰好被遍历一次
        # 如果有节点被访问超过一次或有节点没被访问过，则是无效二叉树
        # 这里是bfs
        q.put(root)
        while not q.empty():
            node = q.get()
            if node in seen:
                return False
            seen.add(node)

            if leftChild[node] != -1:
                q.put(leftChild[node])
            if rightChild[node] != -1:
                q.put(rightChild[node])

        return len(seen) == n


if __name__ == '__main__':
    num = 4
    left = [1, -1, 3, -1]
    right = [2, -1, -1, -1]
    res = Solution().answer(num, left, right)
    print(res)
