package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-26
 */
public class FactorialTrailingZeroes {
    /**
     * problem 172
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
     *
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     *
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    /**
     * 思路：
     * 尾数的零只能由 2x5 产生，由于阶乘中偶数的个数比5的倍数的个数多，所以只考虑5的倍数即可
     * 对于5*5， 5*5*5，5*5*5*5，……，这种情况要多次循环才可以
     * <p>
     * https://blog.csdn.net/TommyZht/article/details/46309563
     */

    public static void main(String[] args) {
        int n = 3;
        int res = new FactorialTrailingZeroes().trailingZeroes(n);
        System.out.println(res);
    }
}
