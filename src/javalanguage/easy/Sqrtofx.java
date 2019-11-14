package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class Sqrtofx {
    /**
     * problem 69
     * https://leetcode-cn.com/problems/sqrtx/
     *
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     * 输入: 4
     * 输出: 2
     *
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */

    /**
     * 二分
     * time: O(logn)
     * space: O(1)
     */
    public int mySqrt_binary(int x) {
        // int -> 大整型测试用例
        // 需要将指针设置成long
        long left = 0, right = x / 2 + 1, mid;

        while (left < right) {
            // 取右中位数
            mid = (left + right + 1) >>> 1;
            if (mid * mid > x) {
                // 一定不是mid
                right = mid - 1;
            } else {
                // 左边包含mid
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * 牛顿迭代法
     * https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
     * time: O(logn) 每次res的值会近似减少一半
     * space: O(1)
     */
    public int mySqrt_newton(int x) {
        // 注意不能用double
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int x = 7;
        int res = new Sqrtofx().mySqrt_binary(x);
        System.out.println(res);
    }
}
