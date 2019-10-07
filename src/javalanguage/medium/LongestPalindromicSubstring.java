package javalanguage.medium;

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
    public String longestPalindrome(String s) {
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
            len --;
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

    public static void main(String[] args) {
        String s = "aa";
        String res = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(res);
    }
}
