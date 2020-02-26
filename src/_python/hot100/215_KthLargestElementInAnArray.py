# coding:utf-8


from typing import List


class Solution:
    """
    problem 215
    https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5

    示例 2:
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4

    说明:
    你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
    """

    def findKthLargest(self, nums: List[int], k: int) -> int:
        self.length = len(nums)
        self.nums = nums
        index = self.length - k
        # 排序partition的方法
        # return self._find_index_value_(0, self.length - 1, index)

        # 堆
        import heapq
        return heapq.nlargest(k, nums)[-1]

    def _find_index_value_(self, start: int, end: int, index: int) -> int:
        if not (start <= index <= end):
            return -1

        stable_position = self._partition_(start, end)
        if stable_position == index:
            return self.nums[stable_position]
        elif stable_position < index:
            return self._find_index_value_(stable_position + 1, end, index)
        else:
            return self._find_index_value_(start, stable_position - 1, index)

    def _partition_(self, start: int, end: int) -> int:
        small = start - 1
        for i in range(start, end):
            if self.nums[i] < self.nums[end]:
                small += 1
                if i != small:
                    self._swap_(i, small)
        small += 1
        self._swap_(small, end)
        return small

    def _swap_(self, i: int, j: int):
        temp = self.nums[i]
        self.nums[i] = self.nums[j]
        self.nums[j] = temp


if __name__ == '__main__':
    nums = [3, 2, 3, 1, 2, 4, 5, 5, 6]
    k = 4

    res = Solution().findKthLargest(nums, k)
    print(res)
