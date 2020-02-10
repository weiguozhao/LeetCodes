# coding:utf-8

class Solution:
    """
    problem 72
    https://leetcode-cn.com/problems/edit-distance/

    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    你可以对一个单词进行如下三种操作：
        插入一个字符、删除一个字符、替换一个字符

    示例 1:
    输入: word1 = "horse", word2 = "ros"
    输出: 3
    解释:
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')

    示例 2:
    输入: word1 = "intention", word2 = "execution"
    输出: 5
    解释:
    intention -> inention (删除 't')
    inention -> enention (将 'i' 替换为 'e')
    enention -> exention (将 'n' 替换为 'x')
    exention -> exection (将 'n' 替换为 'c')
    exection -> execution (插入 'u')
    """

    def minDistance(self, word1: str, word2: str) -> int:
        length1 = len(word1)
        length2 = len(word2)
        memo = [[-1 for _ in range(length2 + 1)] for _ in range(length1 + 1)]

        # word2 为空的情况
        for i in range(length1 + 1):
            memo[i][0] = i
        # word1 为空的情况
        for i in range(length2 + 1):
            memo[0][i] = i

        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if word1[i - 1] == word2[j - 1]:
                    memo[i][j] = memo[i - 1][j - 1]
                else:
                    # @曾智祺
                    #
                    # 对 "memo[i-1][j-1] 表示替换操作，memo[i-1][j] 表示删除操作，memo[i][j-1] 表示插入操作" 的补充理解：
                    #
                    # 以 word1 为 "horse"，word2 为 "ros"，且 memo[5][3] 为例，
                    # 即要将 word1 的前 5 个字符转换为 word2 的前 3 个字符，
                    # 也就是将 horse 转换为 ros，因此有：
                    #
                    # 1. memo[i-1][j-1]，即先将word1的前4个字符hors转换为word2的前2个字符ro, 然后将第5个字符word1[4]由e替换为s
                    #    (即替换为word2的第3个字符，word2[2])
                    #
                    # 2. memo[i][j-1]，即先将word1的前5个字符horse转换为word2的前2个字符ro, 然后在末尾插入一个s
                    #
                    # 3. memo[i-1][j]，即先将word1的前4个字符hors转换为word2的前3个字符ros, 然后删除word1的第5个字符

                    memo[i][j] = 1 + min(memo[i][j - 1], memo[i - 1][j], memo[i - 1][j - 1])

        return memo[length1][length2]


if __name__ == '__main__':
    w1 = "intention"
    w2 = "execution"
    print(Solution().minDistance(w1, w2))
