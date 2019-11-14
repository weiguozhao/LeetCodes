package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-19
 */
public class ClimbingStairs {
    /**
     * problem 70
     * https://leetcode-cn.com/problems/climbing-stairs/
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */

    /**
     * 动态规划
     * dp[i] = dp[i-1] + dp[i-2]
     */
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归记忆法
     */
    public int climbStairsRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] count = new int[n + 1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        return methodCount(count, n);
    }

    private int methodCount(int[] count, int n) {
        if (count[n] != 0) {
            return count[n];
        }
        // 记得要对算完的数进行复制
        count[n] = methodCount(count, n - 1) + methodCount(count, n - 2);
        return count[n];
    }

    /**
     * 暴力
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int n = 3;
        int res = new ClimbingStairs().climbStairs(n);
        System.out.println(res);
    }
}
