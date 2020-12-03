#
# @lc app=leetcode.cn id=315 lang=python3
#
# [315] 计算右侧小于当前元素的个数
#

# @lc code=start
class Solution:
    # def countSmallerTL(self, nums: List[int]) -> List[int]:
    #     length = len(nums)
    #     count = [0 for _ in range(length)]
    #     for i in range(length):
    #         if i == length - 1:
    #             break
    #         for n in nums[i+1:]:
    #             if n < nums[i]:
    #                 count[i] += 1
    #     return count

    def countSmaller(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        length = len(nums)

        index_nums = list(zip(range(length), nums))

        def merge_sort(arr):
            if len(arr) <= 1:
                return arr
            mid = len(arr) // 2
            left = merge_sort(arr[:mid])
            right = merge_sort(arr[mid:])
            return merge(left, right)

        def merge(left, right):
            temp = []
            i, j = 0, 0
            while i < len(left) or j < len(right):
                if j == len(right) or i < len(left) and left[i][1] <= right[j][1]:
                    temp.append(left[i])
                    res[left[i][0]] += j
                    i += 1
                else:
                    temp.append(right[j])
                    j+= 1
            return temp
        
        merge_sort(index_nums)
        return res



# @lc code=end

