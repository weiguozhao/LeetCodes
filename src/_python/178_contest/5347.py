# coding:utf-8

from typing import List


class Solution:
    """
    problem 5347
    https://leetcode-cn.com/contest/weekly-contest-178/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

    给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：

        1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
        2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
        3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
        4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]

    注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
    一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，
    每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
    你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
    请你返回让网格图至少有一条有效路径的最小代价。

    示例 1：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/grid1.png
    输入：grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
    输出：3
    解释：你将从点 (0, 0) 出发。
    到达 (3, 3) 的路径为： (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) 花费代价 cost = 1 使
    方向向下 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) 花费代价 cost = 1 使
    方向向下 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) 花费代价 cost = 1 使方向向下 --> (3, 3)
    总花费为 cost = 3.

    示例 2：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/grid2.png
    输入：grid = [[1,1,3],[3,2,2],[1,1,4]]
    输出：0
    解释：不修改任何数字你就可以从 (0, 0) 到达 (2, 2) 。

    示例 3：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/29/grid3.png
    输入：grid = [[1,2],[4,3]]
    输出：1

    示例 4：
    输入：grid = [[2,2,2],[2,2,2]]
    输出：3

    示例 5：
    输入：grid = [[4]]
    输出：0

    提示：
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    """

    def minCost(self, grid: List[List[int]]) -> int:
        import sys
        # TODO 图论的方法，有待深入学习
        #  https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/solution/zui-duan-lu-jing-suan-fa-bfs0-1bfsdijkstra-by-luci/
        direct = [(0, 0), (1, 0), (-1, 0), (0, 1), (0, -1)]
        n, m = len(grid), len(grid[0])
        queue = [(0, 0)]
        dist = [[sys.maxsize for _ in range(m)] for _ in range(n)]
        dist[0][0] = 0
        while queue:
            y, x = queue.pop(0)

            for k in range(1, 5):
                new_x, new_y = x + direct[k][0], y + direct[k][1]
                if new_x < 0 or new_x >= m or new_y < 0 or new_y >= n:
                    continue
                need_change = 0 if grid[y][x] == k else 1
                nd = dist[y][x] + need_change
                if nd < dist[new_y][new_x]:
                    dist[new_y][new_x] = nd
                    queue.append((new_y, new_x))

        return dist[n - 1][m - 1]


if __name__ == '__main__':
    grid = [[2, 2, 2], [2, 2, 2]]
    res = Solution().minCost(grid)
    print(res)
