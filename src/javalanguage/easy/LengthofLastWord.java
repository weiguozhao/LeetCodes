package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class LengthofLastWord {
    /**
     * problem 58
     * https://leetcode-cn.com/problems/length-of-last-word/
     *
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     *
     * 示例:
     * 输入: "Hello World"
     * 输出: 5
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
