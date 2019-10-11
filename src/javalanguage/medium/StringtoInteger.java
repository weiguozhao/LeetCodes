package javalanguage.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoweiguo
 * @date 2019-10-10
 */
public class StringtoInteger {
    /**
     * problem 8
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     */
    public int myAtoi(String str) {
        // 去掉首尾空格
        char[] s = str.trim().toCharArray();
        // 数字集合
        Set<Character> nums = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            nums.add((char) (i + '0'));
        }
        // 去掉首字母不符合要求的
        boolean unvalid = s.length < 1 || (!nums.contains(s[0]) && s[0] != '-' && s[0] != '+') || (s.length == 1 && !nums.contains(s[0]));
        if (unvalid) {
            return 0;
        }
        // 判断结果的正负
        int isPos = 1, i = 0;
        if (s[i] == '-' || s[i] == '+') {
            isPos = s[i] == '-' ? -1 : 1;
            i++;
        }

        // 去掉符号位后首字母不是数字的
        if(!nums.contains(s[i])){
            return 0;
        }

        // 数字转化
        int res = 0;
        for (; i < s.length; i++) {
            if (!nums.contains(s[i])) {
                break;
            }
            boolean upOverflow = isPos == 1 && res > (Integer.MAX_VALUE - (s[i] - '0')) / 10.0;
            if (upOverflow) {
                return Integer.MAX_VALUE;
            }
            boolean downOverflow = isPos == -1 && -1 * res < Integer.MIN_VALUE / 10.0 + (s[i] - '0') / 10.0;
            if (downOverflow) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + s[i] - '0';
        }
        return isPos * res;
    }

    public static void main(String[] args) {
        // -2147483648
        String s = "  -0012a42";
        int res = new StringtoInteger().myAtoi(s);
        System.out.println(res);
    }
}
