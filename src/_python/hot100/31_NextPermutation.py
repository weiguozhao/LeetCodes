# coding:utf-8

from typing import List


class Solution:
    """
    problem 31
    https://leetcode-cn.com/problems/next-permutation/

    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
    """

    def __init__(self):
        self.nums = None
        self.length = 0

    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length <= 1:
            return
        self.nums = nums
        self.length = length

        # index+1及之后部分降序排列，没有下一个排列, nums[index]的值大小不一定
        index = self.length - 2
        while index >= 0:
            if self.nums[index] < self.nums[index + 1]:
                break
            index -= 1

        # 排列倒序无下一个排列
        if index < 0:
            self.nums = self.nums.reverse()
            return

        # 再找出另一个最大索引 other_index 满足 nums[other_index] > nums[index], 一定存在
        other_index = self.length - 1
        while other_index >= 0:
            if self.nums[other_index] > self.nums[index]:
                break
            other_index -= 1

        # 下一个排列保证要比当前排列大，所以选择右侧第一个比 num[index] 大的值进行交换
        self._swap_(index, other_index)

        # 然后再将降序排列的部分转化成升序排列
        self._reverse_(index + 1, self.length - 1)

    def _reverse_(self, i, j):
        while i < j:
            self._swap_(i, j)
            i += 1
            j -= 1

    def _swap_(self, i, j):
        value = self.nums[i]
        self.nums[i] = self.nums[j]
        self.nums[j] = value


if __name__ == '__main__':
    nums = [1, 3, 2]
    Solution().nextPermutation(nums)

    print(nums)
    pass
