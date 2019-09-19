package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-19
 */
public class ClimbingStairs {
    /**
     * problem 70
     * https://leetcode-cn.com/problems/climbing-stairs/
     */

    /**
     * 动态规划
     * dp[i] = dp[i-1] + dp[i-2]
     */
    public int climbStairsDP(int n) {
        if (n == 1) return 1;
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
        if (n == 1) return 1;
        if (n == 2) return 2;
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
