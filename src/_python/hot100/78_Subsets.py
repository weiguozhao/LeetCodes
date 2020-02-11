# coding:utf-8

from typing import List


class Solution:
    """
    problem 78
    https://leetcode-cn.com/problems/subsets/

    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：解集不能包含重复的子集。

    示例:

    输入: nums = [1,2,3]
    输出:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
    """

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.length = len(nums)
        if self.length < 1:
            return [[]]

        self.nums = nums
        self.ans = []
        self._back_trace_(0, [])
        return self.ans

    def _back_trace_(self, index: int, candis: List[int]) -> None:
        if index > self.length:
            return
        self.ans.append(candis.copy())
        for i in range(index, self.length):
            candis.append(self.nums[i])
            self._back_trace_(i + 1, candis)
            candis.pop()


if __name__ == '__main__':
    n = [1, 2, 3]
    res = Solution().subsets(n)
    for it in res:
        print(it)
