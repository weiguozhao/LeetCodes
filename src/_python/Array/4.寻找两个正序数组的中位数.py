#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个正序数组的中位数
#

# @lc code=start
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1, len2 = len(nums1), len(nums2)
        leftMedian, rightMedian, medianIndex = 0, 0, (len1 + len2) >> 1
        index1, index2 = 0, 0
        for i in range(medianIndex+1):
            leftMedian = rightMedian
            if index2 >= len2 or (index1 < len1 and nums1[index1] < nums2[index2]):
                rightMedian = nums1[index1]
                index1 += 1
            else:
                rightMedian = nums2[index2]
                index2 += 1

        if (len1 + len2) % 2 == 0:
            return (leftMedian + rightMedian) / 2
        else:
            return rightMedian


# @lc code=end

