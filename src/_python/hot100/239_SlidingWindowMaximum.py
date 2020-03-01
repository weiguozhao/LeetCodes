# coding:utf-8

from typing import List


class Solution:
    """
    problem 239
    https://leetcode-cn.com/problems/sliding-window-maximum/

    给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回滑动窗口中的最大值。

    示例:
    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7]
    解释:
          滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
    提示：
    你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

    进阶：
    你能在线性时间复杂度内解决此题吗？
    """

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        from collections import deque
        length = len(nums)

        if length * k == 0:
            return []
        if k == 1:
            return nums
        # 双向队列保存窗口内且大于最后加入元素的index
        self.deq = deque()
        self.nums = nums
        self.k = k
        max_index = 0

        for i in range(k):
            self._clean_deque_(i)
            self.deq.append(i)
            if nums[i] > nums[max_index]:
                max_index = i

        ans = [nums[max_index]]
        for i in range(k, length):
            self._clean_deque_(i)
            self.deq.append(i)
            ans.append(nums[self.deq[0]])

        return ans

    def _clean_deque_(self, i):
        # 只保留当前滑动窗口中有的元素的索引
        if self.deq and self.deq[0] == i - self.k:
            self.deq.popleft()
        # 移除比当前元素小的所有元素，它们不可能是最大的
        while self.deq and self.nums[i] > self.nums[self.deq[-1]]:
            self.deq.pop()

    def maxSlidingWindowDynamicProgram(self, nums: List[int], k: int) -> List[int]:
        length = len(nums)
        if length * k == 0:
            return []
        if k == 1:
            return nums

        left = [0] * length
        left[0] = nums[0]
        right = [0] * length
        right[length - 1] = nums[length - 1]
        for i in range(1, length):
            # from left to right
            if i % k == 0:
                # block start
                left[i] = nums[i]
            else:
                left[i] = max(left[i - 1], nums[i])
            # from right to left
            j = length - i - 1
            if (j + 1) % k == 0:
                # block end
                right[j] = nums[j]
            else:
                right[j] = max(right[j + 1], nums[j])

        ans = []
        for i in range(length - k + 1):
            ans.append(max(left[i + k - 1], right[i]))
        return ans


if __name__ == '__main__':
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    res = Solution().maxSlidingWindow(nums, k)
    print(res)
