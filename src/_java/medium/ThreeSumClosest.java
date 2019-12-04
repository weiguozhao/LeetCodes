package _java.medium;

import java.util.Arrays;

/**
 * @author zhaoweiguo
 * @date 2019-10-15
 */
public class ThreeSumClosest {
    /**
     * problem 16
     * https://leetcode-cn.com/problems/3sum-closest/
     *
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            for (int i = k + 1, j = nums.length - 1; i < j; ) {
                int thisSum = nums[k] + nums[i] + nums[j];

                if (thisSum == target) {
                    return thisSum;
                } else if (thisSum < target) {
                    i++;
                    // 解决重复值的问题
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                } else {
                    j--;
                    // 解决重复值的问题
                    while (j >= 0 && nums[j] == nums[j - 1]) {
                        j--;
                    }
                }

                if (Math.abs(res - target) > Math.abs(thisSum - target)) {
                    res = thisSum;
                }
            }

            // 解决重复值的问题
            while (k < nums.length - 2 && nums[k] == nums[k + 1]) {
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        int res = new ThreeSumClosest().threeSumClosest(nums, target);
        System.out.println(res);
    }
}
