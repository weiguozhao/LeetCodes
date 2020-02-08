# coding:utf-8

from typing import List


class Solution:
    """
    problem 46
    https://leetcode-cn.com/problems/permutations/

    给定一个没有重复数字的序列，返回其所有可能的全排列。

    示例:
    输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
    """

    def permute(self, nums: List[int]) -> List[List[int]]:
        self.length = len(nums)
        if self.length <= 1:
            return [nums]

        self.nums = nums
        self.res = []
        self.flag = [False for _ in range(self.length)]
        self._dfs_([])
        return self.res

    def _dfs_(self, candis: List[int]):
        if len(candis) == self.length:
            self.res.append(candis.copy())

        for i in range(self.length):
            if self.flag[i]:
                continue
            candis.append(self.nums[i])
            self.flag[i] = True
            self._dfs_(candis)
            candis.pop()
            self.flag[i] = False


if __name__ == '__main__':
    nums = [1, 2, 3]

    res = Solution().permute(nums)
    for item in res:
        print(item)

