package easy;

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
