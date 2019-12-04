package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class ReverseInteger {
    /**
     * problem 7.
     * https://leetcode-cn.com/problems/reverse-integer/
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     *  示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * */
    public int temperse(int x) {
        int tailMaxInt = Integer.MAX_VALUE % 10;
        int tailMinInt = Integer.MIN_VALUE % 10;

        int temp = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // positve number
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && pop > tailMaxInt)) {
                return 0;
            }
            // negative number
            if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && pop < tailMinInt)) {
                return 0;
            }

            temp = temp * 10 + pop;
        }

        return temp;
    }

    /**
     * 重点在于分析溢出的条件(以temp为正数为例)：
     *
     * 如果 temp * 10 + pop 导致溢出，那么一定有 temp * 10 >= MAX_INT
     *
     * 然后分两种情况讨论：
     * if (temp*10 > MAX_INT) => temp*10+pop 一定会溢出，需要返回0
     * if (temp*10 == MAX_INT) => pop > MAX_INT%10 一定会溢出，需要返回0
     *
     * 注意：
     * 先判断之后赋值会不会溢出，再进行运算
     * */

    public static void main(String[] args) {
        int x = 123;

        ReverseInteger obj = new ReverseInteger();
        int res = obj.temperse(x);

        System.out.println(res);
    }
}
