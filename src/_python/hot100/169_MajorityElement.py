# coding:utf-8

from typing import List


class Solution:
    """
    problem 169
    https://leetcode-cn.com/problems/majority-element/

    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1:
    输入: [3,2,3]
    输出: 3

    示例 2:
    输入: [2,2,1,1,1,2,2]
    输出: 2
    """

    def majorityElement(self, nums: List[int]) -> int:
        self.length = len(nums)
        self.nums = nums
        self.index = self.length // 2

        key_count = {}
        for n in nums:
            count = key_count.get(n, 0)
            key_count[n] = count + 1
            if count + 1 > self.length // 2:
                return n

        for key, count in key_count:
            if count > self.length // 2:
                return key


if __name__ == '__main__':
    nums = [3, 3, 4]
    res = Solution().majorityElement(nums)
    print(res)
