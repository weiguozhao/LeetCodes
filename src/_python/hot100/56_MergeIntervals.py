# coding:utf-8

from typing import List


class Solution:
    """
    给出一个区间的集合，请合并所有重叠的区间。

    示例 1:
    输入: [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

    示例 2:
    输入: [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
    """

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        length = len(intervals)
        if length <= 1:
            return intervals
        intervals = sorted(intervals, key=lambda x: x[0])

        ans = []
        start, end, i = intervals[0][0], intervals[0][1], 0
        while i < length:
            if end >= intervals[i][0]:
                end = max(end, intervals[i][1])
                i += 1
            else:
                ans.append([start, end])
                if i >= length:
                    break
                start = intervals[i][0]
                end = intervals[i][1]
                i += 1
        ans.append([start, end])

        return ans


if __name__ == '__main__':
    inters = [[1, 4], [4, 5]]
    res = Solution().merge(inters)
    for it in res:
        print(it)
