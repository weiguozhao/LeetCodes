package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-15
 */
public class Pow_xn {
    /**
     * problem 50
     * https://leetcode-cn.com/problems/powx-n/
     * <p>
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * <p>
     * 示例 2:
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * <p>
     * 示例 3:
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * <p>
     * 说明:
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            if (1 > Double.MAX_VALUE / (temp * temp)) {
                return 0.0;
            }
            return temp * temp;
        } else {
            if (x > Double.MAX_VALUE / (temp * temp)) {
                return 0.0;
            }
            return temp * temp * x;
        }
    }

    public double myPowAnswer(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n >> 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }

    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;

        double res = new Pow_xn().myPowAnswer(x, n);
        System.out.println(res);
    }
}
