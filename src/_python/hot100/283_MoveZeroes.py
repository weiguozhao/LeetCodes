# coding:utf-8

from typing import List


class Solution:
    """
    problem 283
    https://leetcode-cn.com/problems/move-zeroes/

    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]

    说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
    """

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        def _swap_(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        slow, fast, length = 0, 0, len(nums)
        while slow < length and nums[slow] != 0:
            slow += 1
        if slow == length:
            return

        fast = slow + 1
        while fast < length:
            if nums[fast] != 0:
                _swap_(slow, fast)
                slow += 1
            fast += 1


if __name__ == '__main__':
    nums = [0, 1, 0, 3, 12]
    Solution().moveZeroes(nums)
    print(nums)
