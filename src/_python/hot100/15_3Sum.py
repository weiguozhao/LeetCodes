# coding:utf-8

from typing import List


class Solution:
    """
    problem 15
    https://leetcode-cn.com/problems/3sum/

    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    示例：
    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
    """

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        总的时间复杂度: O(NlogN) + O(N) * O(N) = O(N^2)
        :param nums:
        :return:
        """
        length = len(nums)
        res = []

        if len(nums) < 3 or not nums:
            return res

        # 排序时间复杂度 O(NlogN)
        nums = sorted(nums)

        # 遍历数组时间复杂度 O(N)
        for k in range(length):

            # 排好序,后面不可能有三个数加和等于0
            if nums[k] > 0:
                return res

            if k != 0 and nums[k] == nums[k - 1]:
                continue

            # 双指针遍历数组 O(N)
            i, j = k + 1, length - 1
            while i < j:
                if nums[k] + nums[i] + nums[j] == 0:
                    # 添加结果
                    res.append([nums[k], nums[i], nums[j]])

                    # 去除左端重复解
                    while i < j and nums[i] == nums[i + 1]:
                        i += 1
                    # 去除右端重复解
                    while i < j and nums[j] == nums[j - 1]:
                        j -= 1
                    i += 1
                    j -= 1

                elif nums[k] + nums[i] + nums[j] > 0:
                    j -= 1

                else:
                    i += 1

        return res


if __name__ == '__main__':
    nums = [-2, -1, -1, 0, 1, 2]
    res = Solution().threeSum(nums)
    print(res)
