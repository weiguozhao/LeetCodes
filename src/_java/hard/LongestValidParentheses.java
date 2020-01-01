package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2019-12-30
 */
public class LongestValidParentheses {
    /**
     * problem 32
     * https://leetcode-cn.com/problems/longest-valid-parentheses/
     *
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     *
     * 示例 1:
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     *
     * 示例 2:
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     * */

    /**
     * dp[i] 表示以 index=i 结尾的最长有效括号子串长度
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     */
    public int longestValidParentheses(String s) {
        int index = s.indexOf('(');
        if (index < 0) {
            return 0;
        }
        s = s.substring(index);

        int length = s.length();
        if (length < 1) {
            return 0;
        }

        int[] dp = new int[length];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }

            if (s.charAt(i - 1) == '(') {
                // 子串以 () 结尾，直接 +2
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                // 子串以 )) 结尾，要考虑前面存在另外的一个 ( 和末尾 ) 匹配
                // 同时将 dp[i - dp[i - 1] - 2] 部分加上
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }

            maxLength = Math.max(dp[i], maxLength);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        String s = ")()())";
        int res = new LongestValidParentheses().longestValidParentheses(s);
        System.out.println(res);
    }
}
