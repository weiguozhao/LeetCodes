package _java.easy;

import java.util.Arrays;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class PlusOne {
    /**
     * problem 66
     * https://leetcode-cn.com/problems/plus-one/
     *
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     *
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
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
