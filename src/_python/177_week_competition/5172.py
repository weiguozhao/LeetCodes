# coding:utf-8

from typing import List


class Solution:
    """
    给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
    由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
    如果无法得到答案，请返回一个空字符串。

    示例 1：
    输入：digits = [8,1,9]
    输出："981"

    示例 2：
    输入：digits = [8,6,7,1,0]
    输出："8760"

    示例 3：
    输入：digits = [1]
    输出：""

    示例 4：
    输入：digits = [0,0,0,0,0,0]
    输出："0"

    提示：
    1 <= digits.length <= 10^4
    0 <= digits[i] <= 9
    返回的结果不应包含不必要的前导零。
    """

    def largestMultipleOfThree(self, digits: List[int]) -> str:
        """
        1. 如果取模3等于0，那其实可以都要
        2. 如果是1，那就得去掉一个1或者两个2
        3. 如果是2那就得去掉一个2或者两个1.
        """
        count = [0 for _ in range(10)]
        rest = 0  # sum总和的余数
        for n in digits:
            count[n] += 1
            rest = (rest + n) % 3

        if rest == 0:
            pass
        elif rest == 1:
            find = False
            for i in range(10):
                if i % 3 == 1 and count[i] > 0:
                    find = True
                    count[i] -= 1
                    break

            if not find:
                l = 2  # rest==1也有可能是`两`个%3==2的元素产生的
                for i in range(10):
                    while l > 0 and i % 3 == 2 and count[i] > 0:
                        count[i] -= 1
                        l -= 1
        else:  # p == 2
            find = False
            for i in range(10):
                if i % 3 == 2 and count[i] > 0:
                    find = True
                    count[i] -= 1
                    break

            if not find:
                l = 2  # rest==2也有可能是`两`个%3==1的元素产生的
                for i in range(10):
                    while l > 0 and i % 3 == 1 and count[i] > 0:
                        count[i] -= 1
                        l -= 1

        ans = ""
        for i in range(9, -1, -1):
            # 从后往前拼接结果
            while count[i] > 0:
                ans += str(i)
                count[i] -= 1

        if len(ans) != 0 and ans[0] == '0':
            return "0"
        else:
            return ans


if __name__ == '__main__':
    digits = [5, 8]
    res = Solution().largestMultipleOfThree(digits)
    print(res)
