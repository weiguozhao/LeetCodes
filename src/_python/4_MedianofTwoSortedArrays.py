# coding:utf-8

from typing import List


class Solution:
    """
    problem 4: 寻找两个有序数组的中位数
    https://leetcode-cn.com/problems/median-of-two-sorted-arrays

    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:
    nums1 = [1, 3]
    nums2 = [2]
    则中位数是 2.0

    示例 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    则中位数是 (2 + 3)/2 = 2.5
    """
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        根据元素个数除以2得到的index是右中位数的index
        当个数为偶数个时，中位数应该为左中位数、右中位数的平均值
        当个数为奇数个时，中位数为右中位数 (此时左中位数等于右中位数)
        :param nums1:
        :param nums2:
        :return:
        """
        m, n = len(nums1), len(nums2)
        i, j,  = 0, 0
        #  取右中位数的index
        median_index, left_median, right_median = (m + n) / 2, 0, 0

        # 终止条件为找到右中位数
        while i + j <= median_index:
            # 暂存左中位数
            left_median = right_median
            # 以下二分查找
            if j >= n or (i < m and nums1[i] < nums2[j]):
                right_median = nums1[i]
                i += 1
            else:
                right_median = nums2[j]
                j += 1

        if (m + n) % 2 == 0:
            return (left_median + right_median) / 2.0
        else:
            return right_median


if __name__ == '__main__':
    nums1 = [1, 2]
    nums2 = [3, 4]
    median = Solution().findMedianSortedArrays(nums1, nums2)
    print(median)
