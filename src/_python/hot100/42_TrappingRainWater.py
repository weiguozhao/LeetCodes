# coding:utf-8

from typing import List


class Solution:
    """
    problem 42
    https://leetcode-cn.com/problems/trapping-rain-water/

    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    示例:
    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6
    """

    def trap(self, height: List[int]) -> int:
        length = len(height)

        max_height = 0
        left_part = [0 for _ in range(length)]
        for i in range(length):
            left_part[i] = max_height
            if height[i] > max_height:
                max_height = height[i]

        max_height = 0
        right_part = [0 for _ in range(length)]
        for i in range(length - 1, -1, -1):
            right_part[i] = max_height
            if height[i] > max_height:
                max_height = height[i]

        res = 0
        for i in range(length):
            water_store = min(left_part[i], right_part[i]) - height[i]
            res += water_store if water_store > 0 else 0

        return res


if __name__ == '__main__':
    height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    res = Solution().trap(height)
    print(res)
