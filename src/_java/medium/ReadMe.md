There are some important problems in medium level.
--------------

- 3 [无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
    - 滑动窗口
- 5 [*****最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
    - 暴力
    - [动态规划](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/)
    - 中心拓展
    - [Manacher算法](https://weiguozhao.github.io/2018/05/10/LongestPalindromicSubstring/)
- 8 [字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)
    - 加减法越界判断：看标志位
    - 乘法越界判断：除回来和原来的数字不一样
- 11 [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
    - 双指针法
- 17 [***电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
    - 回溯
- add [*KSum](https://leetcode-cn.com/problems/4sum/solution/kshu-zhi-he-de-tong-yong-mo-ban-by-mrxiong/)
    - k个数的和等于给定值
    - 递归；回溯
- 19 [删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/)
    - 适当添加链表的头节点
- 29 [两数相除](https://leetcode-cn.com/problems/divide-two-integers/)
    - 基本上只要是限制使用某些运算的，都需要位操作来实现
- 31 [**下一个排列](https://leetcode-cn.com/problems/next-permutation/)
    - [Wikipedia解法](https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/)
- 33 [***搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
    - 变化的二分查找
    - 讨论区解：分两次找，一次找左边界，第二次找右边界 = log(n) + log(n)
- 36 [*有效的数独](https://leetcode-cn.com/problems/valid-sudoku/)
    - 重点分析数Box的Index
- 40 [*组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)
    - 注意要让candidate数组中的每个数都有机会被用到
- 47 [*全排列 II](https://leetcode-cn.com/problems/permutations-ii)
    - 注意[剪枝分析](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/)
- 50 [*Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)
    - 学习别人的代码：[思路清晰、代码简洁](https://leetcode-cn.com/problems/powx-n/solution/qing-xi-jian-dan-de-dan-han-shu-di-gui-wu-lei-xing/)
- 54 [**螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)
    - 通过[两个数组表示方向访问矩阵进行操作](https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/)的典型题目
- 63 [不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)
    - 动态规划尽量用自底向上的循环方式，少用自顶向下的递归方式，递归方式容易超时、栈溢出




