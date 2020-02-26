# coding:utf-8

from typing import List

import numpy as np


class Solution:
    """
    给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
        1. 两数乘积等于  num + 1 或 num + 2
        2. 以绝对差进行度量，两数大小最接近
    你可以按任意顺序返回这两个整数。

    示例 1：
    输入：num = 8
    输出：[3,3]
    解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。

    示例 2：
    输入：num = 123
    输出：[5,25]

    示例 3：
    输入：num = 999
    输出：[40,25]

    提示：
    1 <= num <= 10^9
    """

    def closestDivisors(self, num: int) -> List[int]:
        ans_num1 = self._get_num_(num + 1)
        ans_num2 = self._get_num_(num + 2)
        if ans_num1[1] - ans_num1[0] < ans_num2[1] - ans_num2[0]:
            return ans_num1
        else:
            return ans_num2

    def _get_num_(self, num) -> List[int]:
        sqrt_num = int(np.sqrt(num))
        if sqrt_num * sqrt_num == num:
            return [sqrt_num, sqrt_num]

        for n in range(sqrt_num, 0, -1):
            if num % n == 0:
                return [n, num // n]


if __name__ == '__main__':
    res = Solution().closestDivisors(999)
    print(res)