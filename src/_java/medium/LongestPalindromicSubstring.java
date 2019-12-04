package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-07
 */
public class LongestPalindromicSubstring {
    /**
     * problem 5
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     *
     * 题解：
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
     *
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */

    /**
     * 暴力超时
     */
    public String longestPalindrome_Simply(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String res = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (isPalindromicSubstring(s.substring(i, j))) {
                    res = res.length() > j - i ? res : s.substring(i, j);
                }
            }
        }
        return res;
    }

    private boolean isPalindromicSubstring(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心拓展法
     */
    public String longestPalindrome_expand(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String res = "";
        int length = s.length(), len;
        for (int i = 0; i < length; i++) {
            // 以i为中心，奇数个字符
            len = 0;
            while (i - len >= 0 && i + len < length && s.charAt(i - len) == s.charAt(i + len)) {
                len++;
            }
            len--;
            res = res.length() > 2 * len + 1 ? res : s.substring(i - len, i + len + 1);

            // 以i，i+1为中心，偶数个字符
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                len = 0;
                while (i - len >= 0 && i + len + 1 < length && s.charAt(i - len) == s.charAt(i + 1 + len)) {
                    len++;
                }
                len--;
                res = res.length() > 2 * (len + 1) ? res : s.substring(i - len, i + len + 2);
            }
        }
        return res;
    }

    /**
     * 动态规划
     * p[i][j] = 1 if s[i]=s[j] && p[i+1]==p[j-1]
     * p[i][j] = 0 otherwise
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int length = s.length(), start = 0, maxLength = 1, j;
        // TODO 优化空间复杂度，这里其实只用到了二维数组的一半
        // 创建二维数组用来标记从i到j的字串是否是回文
        int[][] flag = new int[length][length];
        for (int i = 0; i < length; i++) {
            flag[i][i] = 1;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                flag[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }
        // l表示字串的长度，从3开始
        for (int l = 3; l < length; l++) {
            // i表示子串开始的位置
            for (int i = 0; i + l - 1 < length; i++) {
                // j表示子串结束的位置
                j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && flag[i + 1][j - 1] == 1) {
                    flag[i][j] = 1;
                    start = i;
                    maxLength = l;
                }
            }
        }
        return s.substring(start, maxLength);

    }

    public static void main(String[] args) {
        String s = "aa";
        String res = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(res);
    }
}
