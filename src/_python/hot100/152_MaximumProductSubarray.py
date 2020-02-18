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


if __name__ == '__main__':
    nums = [-2, 0, -1]
    res = Solution().maxProduct(nums)
    print(res)
