# coding:utf-8

from typing import List


class Solution:
    """
    problem 55
    https://leetcode-cn.com/problems/jump-game/

    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。

    示例 1:
    输入: [2,3,1,1,4]
    输出: true
    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

    示例 2:
    输入: [3,2,1,0,4]
    输出: false
    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
    """

    def canJumpGreedy(self, nums: List[int]) -> bool:
        """
        贪心法：每次能到达的最远位置
        """
        length = len(nums)
        if length <= 1:
            return True

        # 从index=0处能到达的最远index
        futherest_jump = 0
        for i, jump in enumerate(nums):
            # i <= futherest_distance 表示可以跳到当前index
            # futherest_distance < i + n 表示当前的futherest_distance表示的还不是最远到达的距离
            if i <= futherest_jump < i + jump:
                futherest_jump = i + jump

        return futherest_jump >= length - 1

    def canJumpBackTrace(self, nums: List[int]) -> bool:
        """
        还是要画解答树来确定是否是回溯问题
        """
        return self._back_trace_(nums, 0)

    def _back_trace_(self, nums: List[int], index: int) -> bool:
        length = len(nums)
        if index == length - 1:
            return True

        futherest_jump = min(index + nums[index], length - 1)
        for next_index in range(index + 1, futherest_jump + 1):
            if self._back_trace_(nums, next_index):
                return True

        return False

    def canJump(self, nums: List[int]) -> bool:
        """
        自底向上的动态规划
        """
        length = len(nums)
        if length <= 1:
            return True

        ans = [False for _ in range(length)]
        ans[length - 1] = True

        for i in range(length - 2, -1, -1):
            max_jump = min(i + nums[i], length - 1)
            for j in range(i + 1, max_jump + 1):
                if ans[j]:
                    ans[i] = True
                    break

        return ans[0]


if __name__ == '__main__':
    nums = [2, 0, 0]
    res = Solution().canJump(nums)
    print(res)
