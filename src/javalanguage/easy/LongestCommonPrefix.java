package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class LongestCommonPrefix {
    /**
     * problem 14.
     * https://leetcode-cn.com/problems/longest-common-prefix/
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     * */

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        //find the shortest string
        int minlengthIndex = 0;
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (length > strs[i].length()) {
                length = strs[i].length();
                minlengthIndex = i;
            }
        }

        //find the longest common prefix
        //找到和sub的公共部分作为新的sub
        String sub = strs[minlengthIndex];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                // sub每次从尾部删除一个字符
                sub = sub.substring(0, sub.length() - 1);
            }
        }
        return sub;
    }

    public String longestCommonPrefix_mine(String[] strs) {
        String res = "";

        if (strs.length == 0 || strs == null) {
            return res;
        } else if (strs.length == 1) {
            return strs[0];
        }

        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minlength) {
                minlength = strs[i].length();
            }
        }

        boolean flag = true;
        for (int j = 0; j < minlength; j++) {
            char ch = strs[0].charAt(j);

            for (int k = 1; k < strs.length; k++) {
                if (strs[k].charAt(j) == ch) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res += ch;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String res = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(res);
    }
}
