package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-21
 */
public class JumpGame {
    /**
     * problem 55
     * https://leetcode-cn.com/problems/jump-game/
     * <p>
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * <p>
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * <p>
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */
    public boolean canJump(int[] nums) {
        // method1: traditional back trace
//        return canJumpFromPositionBackTrace(0, nums);

        // method2: dynamic program top and below
//        memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//        return canJumpFromPositionDynamicProgramTopAndBelow(0, nums);

        // method3: dynamic program below and top
        return canJumpDynamicProgramBelowAndTop(nums);
    }

    /**
     * 回溯法
     * 这是一个低效的解决方法。我们模拟从第一个位置跳到最后位置的所有方案。从第一个位置开始，模拟所有可以跳到的位置，
     * 然后从当前位置重复上述操作，当没有办法继续跳的时候，就回溯。
     */
    public boolean canJumpFromPositionBackTrace(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        // NEW: 一个快速的优化方法是我们可以从右到左的检查 nextposition ，理论上最坏的时间复杂度复杂度是一样的。
        //      但实际情况下，对于一些简单场景，这个代码可能跑得更快一些。
        // for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
        // OLD
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionBackTrace(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 自顶向下的动态规划
     */
    enum Index {
        /*
         * GOOD: can jump to last
         * BAD: can not jump to last
         * UNKNOWN: unknown
         * */
        GOOD, BAD, UNKNOWN
    }

    private Index[] memo;

    public boolean canJumpFromPositionDynamicProgramTopAndBelow(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionDynamicProgramTopAndBelow(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    /**
     * 自底向上的动态规划
     */
    public boolean canJumpDynamicProgramBelowAndTop(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        boolean res = new JumpGame().canJump(nums);
        System.out.println(res);
    }
}
