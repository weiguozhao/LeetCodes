# coding:utf-8

from typing import List


class Solution:
    """
    problem 11
    https://leetcode-cn.com/problems/container-with-most-water/

    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。

    https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
    图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

    示例:
    输入: [1,8,6,2,5,4,8,3,7]
    输出: 49
    """

    def maxArea(self, height: List[int]) -> int:
        """
        暴力法
        :param height:
        :return:
        """
        max_area = 0
        length = len(height)
        for i in range(length):
            for j in range(i, length):
                this_area = (j - i) * min(height[i], height[j])
                if max_area < this_area:
                    max_area = this_area
        return max_area

    def maxAreaDoublePointer(self, height: List[int]) -> int:
        """
        双指针法
        :param height:
        :return:
        """
        left, right = 0, len(height) - 1
        max_area = 0

        while left < right:
            this_area = (right - left) * min(height[left], height[right])
            if max_area < this_area:
                max_area = this_area

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_area


if __name__ == '__main__':
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    res = Solution().maxAreaDoublePointer(height)
    print(res)
