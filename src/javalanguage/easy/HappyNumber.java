package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class HappyNumber {
    /**
     * problem 202
     * https://leetcode-cn.com/problems/happy-number/
     *
     * 编写一个算法来判断一个数是不是“快乐数”。
     *
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
     * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     *
     * 示例: 
     * 输入: 19
     * 输出: true
     *
     * 解释:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0, bit;
        while (n != 0) {
            bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }

    /**
     * 思路：
     * 同链表判环一样的思路，快慢指针
     * 当快指针等于慢指针的时候存在环路，这个环路的入口等于1则是快乐的，反之不快乐
     */

    public static void main(String[] args) {
        int n = 19;
        boolean res = new HappyNumber().isHappy(n);
        System.out.println(res);
    }
}
