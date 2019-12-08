package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class DecodeWays {
    /**
     * problem 91
     * https://leetcode-cn.com/problems/decode-ways/
     *
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     *
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * */

    /**
     * 注意 0 的情况, 动态规划：dp[i] 表示 s[0...i] 的译码方法总数
     *
     *  s[i]='0': s[i-1] = '1'or'2', 则 dp[i] = dp[i-2]; 否则 return 0
     *         解释：s[i-1]+s[i] 唯一被译码，不增加情况
     *  s[i-1]='1': 则 dp[i] = dp[i-1] + dp[i-2]
     *         解释：s[i-1]与s[i]分开译码为dp[i-1]; 合并译码为dp[i-2]
     *  s[i-1]='2' and '1'<=s[i]<='6': 则 dp[i] = dp[i-1] + dp[i-2]
     *         解释：同上
     *
     *  同时：dp[i] 仅可能与前两项有关，故可以用单变量代替 dp[] 数组，将空间复杂度从 O(n) 降到 O(1)
     * */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int previous = 1, current = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = current;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    current = previous;
                } else {
                    // 无效译码
                    return 0;
                }
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && '1' <= s.charAt(i) && s.charAt(i) <= '6')) {
                // s.charAt(i) != '0' && 1 -> 26
                current = current + previous;
            }
            previous = temp;
        }
        return current;
    }

    public static void main(String[] args) {
        String s = "12";
        int res = new DecodeWays().numDecodings(s);
        System.out.print(res);
    }
}
