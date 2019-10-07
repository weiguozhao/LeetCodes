package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-07
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * problem 3
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */

    /**
     * 这里注意时间窗口的概念
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     * */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0, j = 0; j < s.length() && i <= j; ) {
            char current = s.charAt(j);
            int index = hasCurrentCharater(s.substring(i, j), current);

            if (index == -1) {
                j++;
            } else {
                i += index;
                j++;
            }
            res = res > j - i ? res : j - i;
        }
        return res;
    }

    /**
     * 这里是自己实现的判断是否存在cur字符的函数，
     * 也可以直接使用 HashSet/HashMap 来判断，以空间换时间
     * */
    private int hasCurrentCharater(String s, char cur) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ab";
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
