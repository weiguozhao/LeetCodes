package _java.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class PalindromeNumber {
    /**
     * problem 9.
     * https://leetcode-cn.com/problems/palindrome-number/
     *
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     * 输入: 121
     * 输出: true
     *
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     * */

    /**
     * 18 ms
     * 39.1 MB
     * */
    public boolean isPalindromeMine(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        List<Integer> nums = new ArrayList<>();
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            nums.add(pop);
        }

        for (int i = 0, j = nums.size() - 1; i <= j; i++, j--) {
            if (!nums.get(i).equals(nums.get(j))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 46 ms
     * 38 MB
     * */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == y;
    }

    /**
     * 思考：转化思路
     *
     * 将判断回文数字 => 数字反转(不存在溢出问题) => 比较反转前后的值是否一致
     *
     * */

    public static void main(String[] args) {
        int x = 121;

        PalindromeNumber obj = new PalindromeNumber();
        boolean res = obj.isPalindrome(x);

        System.out.println(res);
    }
}
