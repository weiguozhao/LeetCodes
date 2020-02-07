# coding:utf-8

from typing import List


class Solution:
    """
    problem 34
    https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:
    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]

    示例 2:
    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]
    """

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        利用二分思想先找其左边界，再找其右边界即可，
        注意找左边界的时候，由左侧逼近；
        找右边界的时候，由右侧逼近。

        时间复杂度：O(logn) + O(logn) = O(logn)
        """
        length = len(nums)
        if length == 0:
            return [-1, -1]

        start = self._find_fist_position_(nums, length, target)
        if start == -1:
            return [-1, -1]
        end = self._find_last_position_(nums, length, target)

        return [start, end]

    def _find_fist_position_(self, nums: List[int], length: int, target: int):
        left, right = 0, length - 1
        while left < right:
            # +1选左
            mid = (left + right) >> 1
            # 严格小于不断调整左边界
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        if nums[left] == target:
            return left
        else:
            return -1

    def _find_last_position_(self, nums: List[int], length: int, target: int):
        left, right = 0, length - 1
        while left < right:
            # -1选右
            mid = (left + right + 1) >> 1
            # 严格大于不断调整右边界
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid

        return left


if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    target = 7

    res = Solution().searchRange(nums, target)
    print(res)
