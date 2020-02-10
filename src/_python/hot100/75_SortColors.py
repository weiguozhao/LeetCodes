# coding:utf-8

from typing import List


class Solution:
    """
    problem 75
    https://leetcode-cn.com/problems/sort-colors/

    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    注意:
    不能使用代码库中的排序函数来解决这道题。

    示例:
    输入: [2,0,2,1,1,0]
    输出: [0,0,1,1,2,2]

    进阶：
    一个直观的解决方案是使用计数排序的两趟扫描算法。
    首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    你能想出一个仅使用常数空间的一趟扫描算法吗？
    """

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        self.length = len(nums)
        if self.length <= 1:
            return
        self.nums = nums
        # self._qsort_(0, self.length - 1)
        self._one_travel_()

    def _one_travel_(self):
        """
        荷兰国旗问题
        """
        left, right, curr = 0, self.length - 1, 0
        # 这里注意要包含等号
        while curr <= right:
            if self.nums[curr] == 0:
                self._swap_(curr, left)
                left += 1
                curr += 1
            elif self.nums[curr] == 2:
                self._swap_(curr, right)
                right -= 1
            else:
                curr += 1

    def _qsort_(self, start: int, end: int):
        """快速排序"""
        if start == end:
            return
        index = self._partition2_(start, end)
        if start < index:
            self._qsort_(start, index - 1)
        if index < end:
            self._qsort_(index + 1, end)

    def _partition_(self, start: int, end: int) -> int:
        if start > end:
            return -1

        small = start - 1
        for i in range(start, end):
            if self.nums[i] < self.nums[end]:
                small += 1
                if small != i:
                    self._swap_(small, i)
        small += 1
        self._swap_(small, end)
        return small

    def _partition2_(self, start: int, end: int) -> int:
        left, right = start, end - 1
        while left < right:
            while left < right and self.nums[left] < self.nums[end]:
                left += 1
            while left < right and self.nums[right] >= self.nums[end]:
                right -= 1
            self._swap_(left, right)

        # 与上面self.nums[right] >= self.nums[end]保持一致，要有等号
        if self.nums[left] < self.nums[end]:
            left += 1
        self._swap_(left, end)
        return left

    def _swap_(self, i, j):
        value = self.nums[i]
        self.nums[i] = self.nums[j]
        self.nums[j] = value


if __name__ == '__main__':
    nums = [2, 0, 2, 1, 1, 0]
    Solution().sortColors(nums)
    print(nums)
