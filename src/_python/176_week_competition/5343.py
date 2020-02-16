# coding:utf-8

import heapq
from typing import List


class Solution:
    """
    给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
        令 x 为你数组里所有元素的和
        选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
        你可以重复该过程任意次
        如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。

    示例 1：
    输入：target = [9,3,5]
    输出：true
    解释：从 [1, 1, 1] 开始
            [1, 1, 1], 和为 3 ，选择下标 1
            [1, 3, 1], 和为 5， 选择下标 2
            [1, 3, 5], 和为 9， 选择下标 0
            [9, 3, 5] 完成

    示例 2：
    输入：target = [1,1,1,2]
    输出：false
    解释：不可能从 [1,1,1,1] 出发构造目标数组。

    示例 3：
    输入：target = [8,5]
    输出：true

    提示：
        N == target.length
        1 <= target.length <= 5 * 10^4
        1 <= target[i] <= 10^9
    """

    def isPossible(self, target: List[int]) -> bool:
        heap = []
        for num in target:
            if num != 1:
                heapq.heappush(heap, -num)

        sum_arr = sum(target)
        while heap:
            top = abs(heapq.heappop(heap))
            new_node = 2 * top - sum_arr
            if new_node < 1:
                return False
            sum_arr = sum_arr - top + new_node
            if new_node != 1:
                heapq.heappush(heap, -new_node)

        return True


if __name__ == '__main__':
    target = [1, 1, 1, 2]
    res = Solution().isPossible(target)
    print(res)
