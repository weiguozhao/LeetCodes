package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2020-01-10
 */
public class JumpGame_II {
    /**
     * problem 45
     * https://leetcode-cn.com/problems/jump-game-ii/
     * <p>
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */

    /**
     * 贪心，每次都要尽力走到最远
     * */
    public int jump(int[] nums) {
        int steps = 0, maxIndex = 0, reachIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachIndex < i) {
                // 走不到这的时候，多走一步step+1
                steps++;
                // 更新可以到达的最远index
                reachIndex = maxIndex;
            }
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int res = new JumpGame_II().jump(nums);
        System.out.println(res);
    }
}
