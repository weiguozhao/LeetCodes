# coding:utf-8

import sys
from typing import List


class Solution:
    """
    problem 152
    https://leetcode-cn.com/problems/maximum-product-subarray/

    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

    示例 1:
    输入: [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。

    示例 2:
    输入: [-2,0,-1]
    输出: 0
    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
    """

    def maxProduct(self, nums: List[int]) -> int:
        length, ans, imax, imin = len(nums), -sys.maxsize - 1, 1, 1
        for i in range(length):
            # 当前数为负数,乘上之前的最小值可能就变成最大值了
            if nums[i] < 0:
                temp = imax
                imax = imin
                imin = temp

            imax = max(imax * nums[i], nums[i])
            imin = min(imin * nums[i], nums[i])

            ans = max(ans, imax)

        return ans

    def maxProduct_memo(self, nums: List[int]) -> int:
        """memo动态规划"""
        length = len(nums)
        memo_max = [1 for _ in range(length)]
        memo_min = [1 for _ in range(length)]
        memo_max[0], memo_min[0], ans = nums[0], nums[0], nums[0]

        for i in range(1, length):
            memo_max[i] = max(memo_max[i - 1] * nums[i], memo_min[i - 1] * nums[i], nums[i])
            memo_min[i] = min(memo_min[i - 1] * nums[i], memo_max[i - 1] * nums[i], nums[i])
            ans = max(ans, memo_max[i])

        return ans


if __name__ == '__main__':
    nums = [2, 3, -2, 4]
    res = Solution().maxProduct_memo(nums)
    print(res)
