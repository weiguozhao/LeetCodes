There are some important problems in hard level.
--------------

- 4 [寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)
    - 注意角度的转换(本题中计数利用中位数的index来控制循环次数,而不是两个数组的size)
- 10 [*****正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)
    - 做题的时候一定要把解答树画出来,根据解答树来判定是 回溯、动规、贪心、…… 等类型问题
    - 回溯和动规通常是不冲突的,动规的时候尽量用自底向上的方式解答
- 23 [***合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
    - 优先队列
    - 归并排序
- 32 [*****最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
    - 动态规划: **先确定动规问题，然后确定公式每个元素代表的含义，最后确定明确的公式**
    - 多轮遍历，字符串
- 37 [解数独](https://leetcode-cn.com/problems/sudoku-solver/)
    - 注意字符和整数之间的转换
        - Int2Char: `char character = (char) (number + '0')`
        - Char2Int: `int number = charater - '0'`

