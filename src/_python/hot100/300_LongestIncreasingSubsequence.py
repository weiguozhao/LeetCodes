# coding:utf-8

from typing import List


class Solution:
    """
    problem 300
    https://leetcode-cn.com/problems/longest-increasing-subsequence/

    给定一个无序的整数数组，找到其中最长上升子序列的长度。

    示例:
    输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

    说明:
    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
    你算法的时间复杂度应该为 O(n2) 。
    进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
    """

    def lengthOfLIS(self, nums: List[int]) -> int:
        # 动态规划 O(n^2)
        length = len(nums)
        if length < 2:
            return length
        memo = [1 for _ in range(length)]
        for i in range(1, length):
            for j in range(i):
                if nums[i] > nums[j]:
                    memo[i] = max(memo[i], memo[j] + 1)

        return memo[length - 1]

    def lengthOfLISDynamicProgramAndBinarySearch(self, nums: List[int]) -> int:
        # 动态规划+二分查找 O(n logn)
        # tails[k] 的值代表 长度为 k+1 子序列的尾部元素值。
        # 二分查找的结果是从tails中找到比当前元素第一大的值 x
        # 相当于在 x 之后加入当前元素，长度+1
        # https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
        tails, ans = [0] * len(nums), 0

        for num in nums:
            i, j = 0, ans
            while i < j:
                m = (i + j) // 2
                if tails[m] < num:
                    i = m + 1
                else:
                    j = m
            tails[i] = num
            if j == ans:
                ans += 1
        return ans


if __name__ == '__main__':
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    res = Solution().lengthOfLIS(nums)
    print(res)
