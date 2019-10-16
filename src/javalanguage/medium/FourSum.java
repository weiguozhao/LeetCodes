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
