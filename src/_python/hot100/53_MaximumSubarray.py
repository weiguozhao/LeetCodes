# coding:utf-8

from typing import List


class Solution:
    """
    problem 53
    https://leetcode-cn.com/problems/maximum-subarray/

    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:
    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    进阶:
    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
    """

    def maxSubArrayGreedy(self, nums: List[int]) -> int:
        length = len(nums)
        curr_sum = max_sum = nums[0]

        for i in range(1, length):
            # 当前元素与当前和的最大值
            curr_sum = max(nums[i], curr_sum + nums[i])
            # 当前最大和与历史最大和的最大值
            max_sum = max(max_sum, curr_sum)

        return max_sum

    def maxSubArrayDivideAndConquer(self, nums: List[int]) -> int:
        return self._devide_and_conquer_(nums, 0, len(nums) - 1)

    def _cross_sum_(self, nums: List[int], left: int, right: int, mid: int) -> int:
        """
        cross部分一定包含 nums[mid], 因此由mid向两端连加取其中最大值
        """
        if left == right:
            return nums[left]

        left_subsum = float('-inf')
        curr_sum = 0
        for i in range(mid, left - 1, -1):
            curr_sum += nums[i]
            left_subsum = max(left_subsum, curr_sum)

        right_subsum = float('-inf')
        curr_sum = 0
        for i in range(mid + 1, right + 1):
            curr_sum += nums[i]
            right_subsum = max(right_subsum, curr_sum)
        return left_subsum + right_subsum

    def _devide_and_conquer_(self, nums: List[int], left: int, right: int) -> int:
        if left == right:
            return nums[left]

        mid = (left + right) >> 1

        left_sum = self._devide_and_conquer_(nums, left, mid)
        right_sum = self._devide_and_conquer_(nums, mid + 1, right)
        cross_sum = self._cross_sum_(nums, left, right, mid)

        return max(left_sum, right_sum, cross_sum)


if __name__ == '__main__':
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    res = Solution().maxSubArrayDivideAndConquer(nums)
    print(res)
