package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class HappyNumber {
    /**
     * problem 202
     * https://leetcode-cn.com/problems/happy-number/
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
