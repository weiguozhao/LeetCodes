package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2019-12-12
 */
public class RegularExpressionMatching {
    /**
     * problem 10
     * https://leetcode-cn.com/problems/regular-expression-matching/
     *
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     *
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     *
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     * 示例 3:
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *
     * 示例 4:
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     *
     * 示例 5:
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     * */

    /**
     * 回溯法
     * <p>
     * Time: O( (T+P)*2^(T+P/2) )
     * Space: O( (T+P)*2^(T+P/2) )
     * <p>
     * 以后做题要先画出解答树，之后根据解答树来判定是 回溯、动规、贪心、……
     */
    public boolean isMatchBackTrace(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 判断第一个字符是否匹配
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 模式串第二个字符是 *
            //
            // 1. 0 次匹配原始串字符
            // 2. 多 次匹配原始串字符
            return (isMatchBackTrace(s, p.substring(2)) || (firstMatch && isMatchBackTrace(s.substring(1), p)));
        } else {
            // 模式串第二个字符不是 *
            // 根据第一个匹配和后面的匹配决定结果
            return firstMatch && isMatchBackTrace(s.substring(1), p.substring(1));
        }
    }

    /**
     * 动态规划自顶向下
     * memo[i][j] 表示 text[i:] 和 pattern[j:] 是否能匹配
     */
    public boolean isMatchDpFromTopToBottom(String text, String pattern) {
        boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
        return isMatchDpFromTopToBottom(0, 0, memo, text, pattern);
    }

    public boolean isMatchDpFromTopToBottom(int i, int j, boolean[][] memo, String text, String pattern) {
        if (memo[i][j]) {
            return true;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (isMatchDpFromTopToBottom(i, j + 2, memo, text, pattern) || firstMatch && isMatchDpFromTopToBottom(i + 1, j, memo, text, pattern));
            } else {
                ans = firstMatch && isMatchDpFromTopToBottom(i + 1, j + 1, memo, text, pattern);
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    /**
     * 动态规划自底向上
     */
    public boolean isMatchDpFromBottomToTop(String text, String pattern) {
        boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
        memo[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    memo[i][j] = memo[i][j + 2] || firstMatch && memo[i + 1][j];
                } else {
                    memo[i][j] = firstMatch && memo[i + 1][j + 1];
                }
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean res = new RegularExpressionMatching().isMatchDpFromBottomToTop(s, p);
        System.out.println(res);
    }
}
