package javalanguage.easy;

import java.util.Arrays;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class PlusOne {
    /**
     * problem 66
     * https://leetcode-cn.com/problems/plus-one/
     */
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        /*
         * 注意digit 和 res 的索引不对应
         * */
        for (int i = digits.length - 1; i >= 0; i--) {
            res[i + 1] = digits[i] + carry;
            if (res[i + 1] > 9) {
                carry = res[i + 1] / 10;
                res[i + 1] %= 10;
            } else {
                carry = 0;
            }
        }
        if (carry > 0) {
            res[0] = carry;
            return res;
        } else {
            return Arrays.copyOfRange(res, 1, res.length);
        }
    }

    /**
     * 需要考虑最终长度不一样的情况
     * 9 -> 10
     */

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        System.out.println("Before plus one:");
        for (int x : digits) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] res = new PlusOne().plusOne(digits);
        System.out.println("After plus one:");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
