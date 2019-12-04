package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-16
 */
public class MaximumSubarray {
    /**
     * problem 53
     * https://leetcode-cn.com/problems/maximum-subarray/
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }

            res = Math.max(sum, res);
        }
        return res;
    }

    /**
     * 分治：
     * max( 左边最大和，右边最大和，跨中间的最大和 )
     */
    public int maxSubArrayDivideConquer(int[] nums) {
        return partMaxSubArray(nums, 0, nums.length - 1);
    }

    public int partMaxSubArray(int[] nums, int left, int right) {
        if (right == left) {
            return nums[left];
        }

        int mid = (left + right) >>> 1;
        int maxOfLeft = partMaxSubArray(nums, left, mid);
        int maxOfRight = partMaxSubArray(nums, mid + 1, right);

        int maxOfMid = 0;
        // 左边部分，从右往左
        int maxL = 0, temp = 0;
        for (int i = mid; i >= 0; i--) {
            temp += nums[i];
            maxL = Math.max(maxL, temp);
        }
        // 右边部分，从左向右
        int maxR = 0;
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            maxR = Math.max(maxR, temp);
        }
        maxOfMid = maxL + maxR;

        return Math.max(Math.max(maxOfLeft, maxOfMid), maxOfRight);
    }

    /**
     * TODO 动态规划+分治法的典型案例：53.最大子序列和
     * https://leetcode-cn.com/problems/maximum-subarray/
     *
     * 详细解析：
     * https://my.oschina.net/itblog/blog/267860
     * - a[i]是负数，那么它不可能代表最优序列的起点;
     * - 任何负的子序列也不可能是最优子序列的前缀
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int res = 0;
        // DP
        res = new MaximumSubarray().maxSubArray(nums);

        // divide-conquer
        res = new MaximumSubarray().maxSubArrayDivideConquer(nums);
        System.out.println(res);
    }
}
