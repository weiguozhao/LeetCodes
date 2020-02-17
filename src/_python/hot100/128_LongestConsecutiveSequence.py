# coding:utf-8

from typing import List


class Solution:
    """
    problem 128
    https://leetcode-cn.com/problems/longest-consecutive-sequence/

    给定一个未排序的整数数组，找出最长连续序列的长度。
    要求算法的时间复杂度为 O(n)。

    示例:
    输入: [100, 4, 200, 1, 3, 2]
    输出: 4
    解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
    """

    def longestConsecutive(self, nums: List[int]) -> int:
        longest_streak = 0
        nums_set = set(nums)

        for num in nums_set:
            if num - 1 not in nums_set:
                current_num = num
                current_streak = 1

                while current_num + 1 in nums_set:
                    current_num += 1
                    current_streak += 1

                longest_streak = max(longest_streak, current_streak)

        return longest_streak

    def longestConsecutiveSort(self, nums: List[int]) -> int:
        if not nums:
            return 0

        nums = sorted(nums)
        longest_streak = 1
        current_streak = 1

        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                if nums[i] == nums[i - 1] + 1:
                    current_streak += 1
                else:
                    longest_streak = max(longest_streak, current_streak)
                    current_streak = 1

        return max(longest_streak, current_streak)

    def longestConsecutiveBruteForce(self, nums: List[int]) -> int:
        longest_streak = 0
        for num in nums:
            current_num = num
            current_streak = 1

            while current_num + 1 in nums:
                current_num += 1
                current_streak = 1

            longest_streak = max(longest_streak, current_streak)

        return longest_streak


if __name__ == '__main__':
    n = [100, 4, 200, 1, 3, 2]
    res = Solution().longestConsecutive(n)
    print(res)
