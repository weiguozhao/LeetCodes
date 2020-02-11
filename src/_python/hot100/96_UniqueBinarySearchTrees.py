# coding:utf-8

class Solution:
    """
    problem 96
    https://leetcode-cn.com/problems/unique-binary-search-trees/

    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    示例:
    输入: 3
    输出: 5
    解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    """

    def numTrees(self, n: int) -> int:
        memo = [0 for _ in range(n + 1)]
        memo[0] = 1
        memo[1] = 1

        for i in range(2, n + 1):
            for j in range(1, i + 1):
                memo[i] += memo[j - 1] * memo[i - j]

        return memo[n]


if __name__ == '__main__':
    res = Solution().numTrees(3)
    print(res)
