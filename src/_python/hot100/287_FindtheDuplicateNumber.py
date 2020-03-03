# coding:utf-8

from typing import List


class Solution:
    """
    problem 287
    https://leetcode-cn.com/problems/find-the-duplicate-number/

    给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设只有一个重复的整数，找出这个重复的数。

    示例 1:
    输入: [1,3,4,2,2]
    输出: 2

    示例 2:
    输入: [3,1,3,4,2]
    输出: 3

    说明：
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n^2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
    """

    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        left, right = 1, size - 1

        while left < right:
            mid = (left + right) >> 1
            cnt = 0
            for num in nums:
                if num <= mid:
                    cnt += 1

            # 根据抽屉原理，小于等于 4 的数的个数如果严格大于 4 个，
            # 此时重复元素一定出现在 [1, 4] 区间里
            if cnt > mid:
                # 重复的元素一定出现在 [left, mid] 区间里
                right = mid
            else:
                # if 分析正确了以后，else 搜索的区间就是 if 的反面
                # [mid + 1, right]
                left = mid + 1
        return left

    def _tortoise_and_rabbit_cyclic_detection_(self, nums: List[int]) -> int:
        """
        不要求掌握，大概了解就行
        弗洛伊德的乌龟和兔子（循环检测，鸽舍原理，抽屉原理）
        https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/
        """
        # Find the intersection point of the two runners.
        tortoise = nums[0]
        hare = nums[0]
        while True:
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
            if tortoise == hare:
                break

        # Find the "entrance" to the cycle.
        ptr1 = nums[0]
        ptr2 = tortoise
        while ptr1 != ptr2:
            ptr1 = nums[ptr1]
            ptr2 = nums[ptr2]

        return ptr1


if __name__ == '__main__':
    nums = [3, 1, 3, 4, 2]
    res = Solution().findDuplicate(nums)
    print(res)
