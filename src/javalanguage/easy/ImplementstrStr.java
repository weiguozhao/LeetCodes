package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class ImplementstrStr {
    /**
     * problem 28
     * https://leetcode-cn.com/problems/implement-strstr/
     * */
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int res = new ImplementstrStr().strStr(haystack, needle);
        System.out.println(res);
    }
}
