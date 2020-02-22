# coding:utf-8

from queue import Queue
from typing import List


class UnionFind:
    """
    并查集
    https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
    """

    def __init__(self, n):
        self.count = n
        # 初始每个人的上级都是自己
        self.parent = [i for i in range(n)]
        # rank可以想成树的层数，root为1
        self.rank = [1 for _ in range(n)]

    def get_count(self):
        return self.count

    def find(self, p):
        """不断向上找上级"""
        while p != self.parent[p]:
            self.parent[p] = self.parent[self.parent[p]]
            p = self.parent[p]
        return p

    def is_connected(self, p, q):
        """通过判断是不是同一个root"""
        return self.find(p) == self.find(q)

    def union(self, p, q):
        p_root = self.find(p)
        q_root = self.find(q)
        if p_root == q_root:
            return

        if self.rank[p_root] > self.rank[q_root]:
            self.parent[q_root] = p_root
        elif self.rank[p_root] < self.rank[q_root]:
            self.parent[p_root] = q_root
        else:
            self.parent[q_root] = p_root
            self.rank[p_root] += 1
        self.count -= 1


class Solution:
    """
    problem 200
    https://leetcode-cn.com/problems/number-of-islands/

    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
    你可以假设网格的四个边均被水包围。

    示例 1:
    输入:
        11110
        11010
        11000
        00000
    输出: 1

    示例 2:
    输入:
        11000
        11000
        00100
        00011
    输出: 3
    """

    def numIslands(self, grid: List[List[str]]) -> int:
        self.rows = len(grid)
        if self.rows == 0:
            return 0
        self.cols = len(grid[0])
        self.grid = grid
        self.visited = [[False for _ in range(self.cols)] for _ in range(self.rows)]
        self.direct = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.queue = Queue()
        self.ans = 0

        # for i in range(self.rows):
        #     for j in range(self.cols):
        #         if self.visited[i][j] is False and self.grid[i][j] == '1':
        #             self.visited[i][j] = True
        #
        #             # method1: deep first search
        #             # self._dfs_(i, j)
        #
        #             # method2: bread first search
        #             self.queue.put((i, j))
        #             self._bfs_()
        #
        #             self.ans += 1
        #
        # return self.ans

        # method3: union find
        return self._union_find_()

    def _dfs_(self, row: int, col: int):
        for direct in self.direct:
            new_row = row + direct[0]
            new_col = col + direct[1]
            if 0 <= new_row < self.rows and 0 <= new_col < self.cols \
                    and self.grid[new_row][new_col] == '1' and self.visited[new_row][new_col] is False:
                self.visited[new_row][new_col] = True
                self._dfs_(new_row, new_col)

    def _bfs_(self):
        while not self.queue.empty():
            row, col = self.queue.get()

            for direct in self.direct:
                new_row = row + direct[0]
                new_col = col + direct[1]
                if 0 <= new_row < self.rows and 0 <= new_col < self.cols \
                        and self.grid[new_row][new_col] == '1' and self.visited[new_row][new_col] is False:
                    self.visited[new_row][new_col] = True
                    self.queue.put((new_row, new_col))

    def _union_find_(self):
        # 不必像DFS和BFS一样4个方向都要尝试, 只要看一看右边和下面就可以
        directions = [(1, 0), (0, 1)]
        # 多开一个空间，把水域 "0" 都归到这个虚拟的老大上
        dummy_node = self.rows * self.cols

        # 多开的一个空间就是那个虚拟的空间
        uf = UnionFind(dummy_node + 1)
        for i in range(self.rows):
            for j in range(self.cols):
                # 如果是水域，都连到那个虚拟的空间去
                if grid[i][j] == '0':
                    uf.union(i * self.cols + j, dummy_node)
                if grid[i][j] == '1':
                    # 向下、向右如果都是陆地, 就要合并一下
                    for direction in directions:
                        new_row = i + direction[0]
                        new_col = j + direction[1]
                        if 0 <= new_row < self.rows and 0 <= new_col < self.cols \
                                and grid[new_row][new_col] == '1':
                            uf.union(i * self.cols + j, new_row * self.cols + new_col)

        # 不要忘记把那个虚拟结点减掉
        return uf.get_count() - 1


def str2grid(s: str) -> List[List[str]]:
    ans = []
    lines = s.split("\n")
    for line in lines:
        rows = []
        for ch in line.strip():
            rows.append(ch)
        ans.append(rows)
    return ans


if __name__ == '__main__':
    grid = str2grid("11000\n"
                    "11000\n"
                    "00100\n"
                    "00011")
    res = Solution().numIslands(grid)
    print(res)
