package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class ReverseBits {
    /**
     * problem 190
     * https://leetcode-cn.com/problems/reverse-bits/
     */
    public int reverseBits(int n) {
        int length = 32;

        int res = n & 1;
        length--;
        while (length > 0) {
            n >>= 1;
            res = res << 1;
            res += n & 1;
            length--;
        }
        return res;
    }

    /**
     * 思路：
     * 简单的位运算，注意 n%2 和 n&1 的结果虽然一样但是效率差别很大
     */

    public static void main(String[] args) {
        int n = -3;
        int res = new ReverseBits().reverseBits(n);
        System.out.println(res);
    }
}
