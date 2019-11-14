package javalanguage.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-15
 */
public class FourSum {
    /**
     * problem 18
     * https://leetcode-cn.com/problems/4sum/
     *
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int k, p, i, j;
        for (k = 0; k < nums.length; k++) {
            for (p = k + 1; p < nums.length; p++) {
                for (i = p + 1, j = nums.length - 1; i < j; ) {
                    int sum = nums[k] + nums[p] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[k], nums[p], nums[i], nums[j]));

                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        i++;

                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        j--;
                    } else if (sum < target) {
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        i++;
                    } else {
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        j--;
                    }
                }

                while (p < nums.length - 1 && nums[p] == nums[p + 1]) {
                    p++;
                }
            }

            while (k < nums.length - 2 && nums[k] == nums[k + 1]) {
                k++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 2, -5, 0, -1, 4};
        int target = 3;

        List<List<Integer>> res = new FourSum().fourSum(nums, target);
        for (List<Integer> temp : res) {
            for (Integer num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
