There are some important problems in hard level.
--------------

- 4 [寻找两个有序数组的中位数](/src/_java/hard/MedianofTwoSortedArrays.java)
    - 注意角度的转换(本题中计数利用中位数的index来控制循环次数,而不是两个数组的size)
- 10 [*****正则表达式匹配](/src/_java/hard/RegularExpressionMatching.java)
    - 做题的时候一定要把解答树画出来,根据解答树来判定是 回溯、动规、贪心、…… 等类型问题
    - 回溯和动规通常是不冲突的,动规的时候尽量用自底向上的方式解答
    - 同44题一起思考，**同样的题目稍微变化了一下条件**
- 44 [*****通配符匹配](/src/_java/hard/WildcardMatching.java)
    - 动态规划
        1. 状态定义
        2. 转移方程
        3. 状态数组初始化
    - 贪心
    - 双指针
- 23 [***合并K个排序链表](/src/_java/hard/MergekSortedLists.java)
    - 优先队列
    - 归并排序
- 32 [*****最长有效括号](/src/_java/hard/LongestValidParentheses.java)
    - 动态规划: **先确定动规问题，然后确定公式每个元素代表的含义，最后确定明确的公式**
    - 多轮遍历，字符串
- 37 [解数独](/src/_java/hard/SudokuSolver.java)
    - 注意字符和整数之间的转换
        - Int2Char: `char character = (char) (number + '0')`
        - Char2Int: `int number = charater - '0'`
- 41 [*****缺失的第一个正数](/src/_java/hard/FirstMissingPositive.java)
    - [bitMap](https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/)
    - [桶排序](https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/)
- 42 [*******接雨水**](/src/_java/hard/TrappingRainWater.java)
    - [暴力法都不容易想](https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/)
    - [双指针](https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/)
    - [动态规划](https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/)
    - [单调栈](https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/)
- 45 [***跳跃游戏 II](/src/_java/hard/JumpGame_II.java)
    - 贪心算法
- 51 [**N皇后](/src/_java/hard/NQueens.java)
    - 思路很简单，实现要注意细节
    - 回溯法的通用结构
    - 同 [52 N皇后 II](/src/_java/hard/NQueens_II.java) 算是一道题目
