# coding:utf-8

from typing import List


class Solution:
    """
    problem 238
    https://leetcode-cn.com/problems/product-of-array-except-self/

    给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

    示例:
    输入: [1,2,3,4]
    输出: [24,12,8,6]

    说明:
    请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    进阶：
    你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
    """

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        left_product = [1 for _ in range(length)]
        right_product = [1 for _ in range(length)]

        for i in range(1, length):
            left_product[i] = nums[i - 1] * left_product[i - 1]
        for i in range(length - 2, -1, -1):
            right_product[i] = nums[i + 1] * right_product[i + 1]

        ans = []
        for i in range(length):
            value = left_product[i] * right_product[i]
            ans.append(value)
        return ans

    def productExceptSelfOptimizeSpace(self, nums: List[int]) -> List[int]:
        length = len(nums)
        ans = [1 for _ in range(length)]

        for i in range(1, length):
            ans[i] = nums[i - 1] * ans[i]

        # 右侧乘积用一个变量暂时保存就可以
        right_product = 1
        for i in range(length - 1, -1, -1):
            ans[i] = ans[i] * right_product
            right_product *= nums[i]

        return ans


if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    res = Solution().productExceptSelfOptimizeSpace(nums)
    print(res)
