package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class LengthofLastWord {
    /**
     * problem 58
     * https://leetcode-cn.com/problems/length-of-last-word/
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " ";

        int res = new LengthofLastWord().lengthOfLastWord(s);
        System.out.println(res);
    }
}
