# coding:utf-8

from typing import List


class Solution:
    """
    problem 33
    https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。

    示例 1:
    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4

    示例 2:
    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1
    """

    def search(self, nums: List[int], target: int) -> int:
        length = len(nums)
        if length <= 0:
            return -1

        left, right = 0, length - 1
        while left < right:
            # +1选左, -1选右, 下面使用右中位数
            mid = (left + right + 1) >> 1

            # [mid, right]一定有序
            if nums[mid] < nums[right]:
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1

            # [left, mid]一定有序, nums[mid] > nums[right]
            else:
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid

        if nums[left] == target:
            return left
        else:
            return -1


if __name__ == '__main__':
    nums1 = [2, 1]
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    res = Solution().search(nums1, 0)
    print(res)
