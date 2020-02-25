# coding:utf-8

from typing import List


class Solution:
    """
    problem 207
    https://leetcode-cn.com/problems/course-schedule/

    现在你总共有 n 门课需要选，记为 0 到 n-1。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
    给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

    示例 1:
    输入: 2, [[1,0]]
    输出: true
    解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

    示例 2:
    输入: 2, [[1,0],[0,1]]
    输出: false
    解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

    说明:
    输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
    你可以假定输入的先决条件中没有重复的边。

    提示:
    这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
    通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
    拓扑排序也可以通过 BFS 完成。
    """

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # return self._bfs_(numCourses, prerequisites)
        return self._dfs_(numCourses, prerequisites)

    def _bfs_(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0 for _ in range(numCourses)]
        adjacency = [[] for _ in range(numCourses)]
        queue = []

        # Get the indegree and adjacency of every course.
        for cur, pre in prerequisites:
            indegrees[cur] += 1
            adjacency[pre].append(cur)

        # Get all the courses with the indegree of 0.
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)

        # BFS TopSort.
        while queue:
            pre = queue.pop(0)
            numCourses -= 1
            for cur in adjacency[pre]:
                # 将pre节点从cur的前置节点中删除
                indegrees[cur] -= 1
                # cur的前置节点都已经完成,此时将cur入队列
                if indegrees[cur] == 0:
                    queue.append(cur)

        return numCourses == 0

    def _dfs_(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 邻接矩阵
        adjacency = [[] for _ in range(numCourses)]
        for cur, pre in prerequisites:
            adjacency[pre].append(cur)

        # 用于判断每个节点 i (课程)的状态
        # 未被 DFS 访问：i == 0
        # 已被其他节点启动的DFS访问：i == -1
        # 已被当前节点启动的DFS访问：i == 1
        flags = [0 for _ in range(numCourses)]
        for i in range(numCourses):
            # 判断每个节点起步的图是否存在环
            if not self._dfs_helper_(i, adjacency, flags):
                return False
        # 不存在环
        return True

    def _dfs_helper_(self, i, adjacency, flags):
        # 已被其他节点启动的DFS访问：i == -1
        if flags[i] == -1:
            return True
        # 已被当前节点启动的DFS访问：i == 1
        if flags[i] == 1:
            return False

        flags[i] = 1
        for j in adjacency[i]:
            if not self._dfs_helper_(j, adjacency, flags):
                return False

        flags[i] = -1
        return True


if __name__ == '__main__':
    nums = 2
    courses = [[1, 0], [0, 1]]
    res = Solution().canFinish(nums, courses)
    print(res)
