package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2020-01-07
 */
public class WildcardMatching {
    /**
     * problem 44
     * https://leetcode-cn.com/problems/wildcard-matching/
     * <p>
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * <p>
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * <p>
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * <p>
     * 示例 3:
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * 示例 4:
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * <p>
     * 示例 5:
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输入: false
     */

    /**
     * 动态规划(自底向上)
     * 1. 状态定义
     * 2. 状态转换方程
     * 3. 初始化转移数组
     *
     * time：O(N^2)
     * space: O(n^2)
     *
     * 注意：
     *  memo[i - 1][j]表示匹配非空字符
     *  memo[i][j - 1]表示匹配空字符
     * */
    public boolean isMatch(String s, String p) {
        int slength = s.length(), plength = p.length();

        // 状态定义: memo[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] memo = new boolean[slength + 1][plength + 1];

        // 两个空字符串
        memo[0][0] = true;

        for (int j = 1; j <= plength; j++) {
            // TODO 当s为空字符串
            if (p.charAt(j - 1) == '*') {
                memo[0][j] = memo[0][j - 1];
            }
        }

        for (int i = 1; i <= slength; i++) {
            for (int j = 1; j <= plength; j++) {
                // 单个字符匹配
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 匹配任意非空字符 || 匹配空字符
                    memo[i][j] = memo[i][j - 1] || memo[i - 1][j];
                }
            }
        }

        return memo[slength][plength];
    }

    public static void main(String[] args) {
        String s = "acccb";
        String p = "a*cb";
        boolean res = new WildcardMatching().isMatch(s, p);
        System.out.println(res);
    }
}
