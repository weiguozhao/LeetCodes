# coding:utf-8

from typing import List


class Solution:
    """
    problem 39
    https://leetcode-cn.com/problems/combination-sum/

    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
    说明：
    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

    示例 1:
    输入: candidates = [2,3,6,7], target = 7,
    所求解集为:
    [
      [7],
      [2,2,3]
    ]

    示例 2:
    输入: candidates = [2,3,5], target = 8,
    所求解集为:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
    """

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.nums = sorted(candidates)
        self.length = len(self.nums)
        self.target = target
        self.res = []

        candis = []
        self.dfs(candis, 0)
        return self.res

    def dfs(self, candis: List[int], index: int):
        s = sum(candis)
        if s > self.target:
            return
        elif s == self.target:
            self.res.append(candis.copy())

        for i in range(index, self.length):
            candis.append(self.nums[i])
            self.dfs(candis, i)
            candis.pop()


if __name__ == '__main__':
    c = [2, 3, 6, 7]
    t = 3
    res = Solution().combinationSum(c, t)
    print(res)
    pass
